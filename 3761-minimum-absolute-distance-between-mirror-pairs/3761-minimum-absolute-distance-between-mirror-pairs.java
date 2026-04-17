class Solution {
    public int minMirrorPairDistance(int[] nums) {
        if (nums.length == 1) return -1;
        int n = nums.length;
        // System.out.println(rev(12000));
        // 1 <= nums.length <= 10^5, meaning solution -- O(n) or O(logn)

        int min = 100001;
        // O(n^2)
        // for (int x = 0; x < n; x++) {
        //     int ele = nums[x];
        //     for (int y = x + 1; y < n; y++) {
        //         // if (ele == rev(nums[y])) min = Math.min(min, y - x);
        //         if (rev(ele) == nums[y]) min = Math.min(min, y - x);
        //         else continue;
        //     }
        // }

        // O(n)
        Map<Integer, List<Integer>> map = new HashMap<>();
        // map.put(nums[n - 1], new ArrayList<>());
        // map.get(nums[n - 1]).add(n - 1);

        for (int x = 0; x < n; x++) {
            if (map.containsKey(nums[x])) {
                int size = map.get(nums[x]).size();
                int diff = Math.abs(x - map.get(nums[x]).get(size - 1));
                // min = Math.min(min, Math.abs(x - map.get(rev(nums[x])).get(size - 1)));
                if (min > diff) min = diff;
                map.get(nums[x]).add(x);
                int y = rev(nums[x]);
                map.put(y, new ArrayList<>());
                map.get(y).add(x);
            }
            // else if (map.containsKey(nums[x])) {

            // }
            else {
                int y = rev(nums[x]);
                map.put(y, new ArrayList<>());
                map.get(y).add(x);
            }
        }

        // System.out.println(map);
        return min == 100001 ? -1 : min;
    }

    private int rev (int x) {
        // Digit Reverse.
        int rev = 0;
        int rem = 0;
        while (x > 0) {
            rem = x % 10;
            rev = rev * 10 + rem;
            x /= 10;
        }

        return rev;
    }
}