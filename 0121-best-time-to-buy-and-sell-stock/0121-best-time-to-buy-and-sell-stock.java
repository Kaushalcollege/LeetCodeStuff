class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;

        for (int i : prices) {
            if (i < min) min = i;

            profit = Math.max(profit, i - min);
        }

        return profit;
    }
}