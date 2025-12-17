class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        if (n < 2 || k == 0) return 0;

        long[][] dp = new long[k + 1][n];

        for (int t = 1; t <= k; t++) {
            long maxNormalBuy = -prices[0];   
            long maxShortSell = prices[0];    

            for (int i = 1; i < n; i++) {
                dp[t][i] = dp[t][i - 1];

                dp[t][i] = Math.max(dp[t][i], prices[i] + maxNormalBuy);

                dp[t][i] = Math.max(dp[t][i], maxShortSell - prices[i]);

                maxNormalBuy = Math.max(maxNormalBuy, dp[t - 1][i - 1] - prices[i]);
                maxShortSell = Math.max(maxShortSell, dp[t - 1][i - 1] + prices[i]);
            }
        }

        return dp[k][n - 1];
    }
}