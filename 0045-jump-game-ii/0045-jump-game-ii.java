class Solution {
    public int jump(int[] nums) {
        return solve(0, nums);
    }

    private int solve(int idx, int[] nums) {
        // Reached or crossed last index → no more jumps needed
        if (idx >= nums.length - 1) return 0;

        // Cannot move forward from here → invalid path
        if (nums[idx] == 0) return Integer.MAX_VALUE;

        int minJumps = Integer.MAX_VALUE;

        // Try ALL possible jumps from this index
        for (int step = 1; step <= nums[idx]; step++) {
            int next = idx + step;
            if (next < nums.length) {
                int res = solve(next, nums);
                if (res != Integer.MAX_VALUE) {
                    minJumps = Math.min(minJumps, 1 + res);
                }
            }
        }

        return minJumps;
    }
}
