class Solution {
    private int getScore(int val) {
        if (val == 1) return 1;
        if (val == 2) return 2;
        return 0;
    }

    private int getCost(int val) {
        if (val == 1) return 1;
        if (val == 2) return 1;
        return 0;
    }

    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    dp[i][j][c] = -1;
                }
            }
        }
        int startVal = grid[0][0];
        int startCost = getCost(startVal);
        int startScore = getScore(startVal);
        if (startCost <= k) {
            dp[0][0][startCost] = startScore;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    if (dp[i][j][c] == -1) continue;
                    int currentScore = dp[i][j][c];
                    if (j + 1 < n) {
                        int nextVal = grid[i][j + 1];
                        int newCost = c + getCost(nextVal);
                        int newScore = currentScore + getScore(nextVal);
                        if (newCost <= k) {
                            dp[i][j + 1][newCost] = Math.max(dp[i][j + 1][newCost], newScore);
                        }
                    }
                    if (i + 1 < m) {
                        int nextVal = grid[i + 1][j];
                        int newCost = c + getCost(nextVal);
                        int newScore = currentScore + getScore(nextVal);
                        if (newCost <= k) {
                            dp[i + 1][j][newCost] = Math.max(dp[i + 1][j][newCost], newScore);
                        }
                    }
                }
            }
        }
        int maxScore = -1;
        for (int c = 0; c <= k; c++) {
            maxScore = Math.max(maxScore, dp[m - 1][n - 1][c]);
        }
        return maxScore;
    }
}
