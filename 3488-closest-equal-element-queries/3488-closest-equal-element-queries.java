class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length, q = queries.length;
        List<Integer> res = new ArrayList<>();

        for (int x = 0; x < n; x++) {
            if (!map.containsKey(nums[x])) {
                map.putIfAbsent(nums[x], new ArrayList<>());
                map.get(nums[x]).add(x);
            }
            else map.get(nums[x]).add(x);
        }

        // System.out.println(map);

        for (int x : queries) {
            // map.get(nums[x]).remove(Integer.valueOf(x));
            // int idx = bin(map.get(nums[x]), x);
            // int diff = Math.abs(x - idx);
            if (map.get(nums[x]).size() > 1) {
                int idx = bin(map.get(nums[x]), x, n);
                // if (x == 8) {
                //     System.out.println(idx);
                //     System.out.println(map.get(nums[x]));
                // }
                int diff = Math.abs(x - idx);
                res.add((diff < n - diff) ? diff : n - diff);
            }

            else res.add(-1);
        }
        // System.out.println(res);

        return res;
    }

private int bin(List<Integer> list, int t, int n) {
    int l = 0, h = list.size() - 1;

    while (l <= h) {
        int m = l + (h - l) / 2;

        if (list.get(m) == t) {

            int left = list.get((m - 1 + list.size()) % list.size());
            int right = list.get((m + 1) % list.size());

            int leftDist = Math.min(Math.abs(left - t), n - Math.abs(left - t));
            int rightDist = Math.min(Math.abs(right - t), n - Math.abs(right - t));

            return (leftDist <= rightDist) ? left : right;
        }
        else if (list.get(m) < t) l = m + 1;
        else h = m - 1;
    }

    return -1;
}
}