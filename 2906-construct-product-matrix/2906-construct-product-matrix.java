class Solution {
    long MOD = 12345;
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] p = new int[n][m];

        long sfx = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                p[i][j] = (int) sfx;
                sfx = (sfx * grid[i][j]) % MOD;
            }
        }

        long pfx = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                p[i][j] = (int) (((long) p[i][j] * pfx) % MOD);
                pfx = (pfx * grid[i][j]) % MOD;
            }
        }

        return p;
    }
}