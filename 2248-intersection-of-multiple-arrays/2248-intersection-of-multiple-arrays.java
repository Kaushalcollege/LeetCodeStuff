class Solution {
    public List<Integer> intersection(int[][] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] arr : nums) for (int x : arr) map.put(x, map.getOrDefault(x, 0) + 1);

        // System.out.println(map);

        List<Integer> res = new ArrayList<>();
        for (int x : map.keySet()) if (map.get(x) == n) res.add(x);

        Collections.sort(res);
        return res;
    }
}