class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1; // not enough jobs
        
        int[][] dp = new int[d + 1][n + 1];
        for (int i = 0; i <= d; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;

        for (int day = 1; day <= d; day++) {
            for (int i = day; i <= n; i++) {
                int max = 0;
                // j marks where the current day's partition starts
                for (int j = i - 1; j >= day - 1; j--) {
                    max = Math.max(max, jobDifficulty[j]);
                    dp[day][i] = Math.min(dp[day][i], dp[day - 1][j] + max);
                }
            }
        }

        return dp[d][n];
    }
}
