class Solution {
    public int climbStairs(int n, int[] costs) {
        // Pad the array to make it 1-indexed
        int[] newCosts = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            newCosts[i] = costs[i - 1];
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;

            // from i-1
            if (i - 1 >= 0)
                dp[i] = Math.min(dp[i], dp[i - 1] + newCosts[i] + 1);

            // from i-2
            if (i - 2 >= 0)
                dp[i] = Math.min(dp[i], dp[i - 2] + newCosts[i] + 4);

            // from i-3
            if (i - 3 >= 0)
                dp[i] = Math.min(dp[i], dp[i - 3] + newCosts[i] + 9);
        }

        return dp[n];
    }
}
