class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int[][] dp = new int[n][2];
        // Base cases
        dp[0][0] = 0;            // no stock on day 0
        dp[0][1] = -prices[0];   // bought stock on day 0

        for (int i = 1; i < n; i++) {
            // either keep not holding, or sell today
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            // either keep holding, or buy today
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }

        return dp[n-1][0]; // max profit with no stock in hand
    }
}
