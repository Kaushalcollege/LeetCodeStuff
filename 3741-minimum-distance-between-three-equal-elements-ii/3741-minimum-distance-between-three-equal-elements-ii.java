class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int ans = Integer.MAX_VALUE;

        // For each number with ≥ 3 occurrences
        for (List<Integer> list : map.values()) {
            if (list.size() >= 3) {
                for (int i = 0; i + 2 < list.size(); i++) {
                    int a = list.get(i), b = list.get(i + 1), c = list.get(i + 2);
                    int dist = Math.abs(a - b) + Math.abs(b - c) + Math.abs(c - a);
                    ans = Math.min(ans, dist);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}