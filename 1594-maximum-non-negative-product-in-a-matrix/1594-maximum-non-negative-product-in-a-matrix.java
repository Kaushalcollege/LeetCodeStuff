class Solution {
    long MAX = 1000000007;
    // long ans = Long.MIN_VALUE;
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long prod = 1;

        // f (0, 0, m, n, 1, grid);
        // if (ans < 0) return -1;
        // return (int)(ans % MAX);

        long[][] max = new long[m][n]; // max dp
        long[][] min = new long[m][n]; // min dp

        max[0][0] = min[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) max[i][0] = min[i][0] = max[i - 1][0] * grid[i][0];
        for (int i = 1; i < n; i++) max[0][i] = min[0][i] = max[0][i - 1] * grid[0][i];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int curr = grid[i][j];

                long a = max[i - 1][j] * curr;
                long b = min[i - 1][j] * curr;
                long c = max[i][j - 1] * curr;
                long d = min[i][j - 1] * curr;

                max[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                min[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        long ans = max[m - 1][n - 1];
        if (ans < 0) return -1;
        return (int) (ans % MAX);
    }

    // private void f (int row, int col, int m, int n, long prod, int[][] grid) {
    //     if (row >= m || col >= n) return;

    //     prod *= grid[row][col];

    //     if (row == m - 1 && col == n - 1) {
    //         ans = Math.max(ans, prod);
    //         return;
    //     }

    //     f (row, col + 1, m, n, prod, grid);
    //     f (row + 1, col, m, n, prod, grid);
    // }
}