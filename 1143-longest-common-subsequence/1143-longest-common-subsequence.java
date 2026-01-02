class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return f (m - 1, n - 1, text1, text2, dp);
    }
    private int f (int i, int j, String s, String t, int[][] memo) {
        if (i < 0 || j < 0) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        if (s.charAt(i) == t.charAt(j)) memo[i][j] = 1 + f (i - 1, j - 1, s, t, memo);
        else memo[i][j] = Math.max(f (i - 1, j, s, t, memo), f (i, j - 1, s, t, memo));

        return memo[i][j];
    }
}