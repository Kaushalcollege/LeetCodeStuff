class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return func (nums, 0, memo);
    }

    private int func (int[] nums, int idx, int[] dp){
        if (idx >= nums.length) return 0;

        if (idx == nums.length - 1) {
            dp[idx] = nums[idx];
            return dp[idx];
        }

        if (dp[idx] != -1) return dp[idx];

        int pick = nums[idx] + func(nums, idx + 2, dp);
        int noPick = func(nums, idx + 1, dp);

        dp[idx] = Math.max(pick, noPick);
        return dp[idx];
    }
}