class Solution {
    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        int res = 0;
        for (int i : map.keySet()) if (map.get(i) == (nums.length / 2)) res = i;
        return res;
    }
}