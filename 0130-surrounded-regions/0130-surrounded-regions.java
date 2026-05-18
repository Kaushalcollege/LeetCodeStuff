class Solution {
    public void solve(char[][] b) {
        int m = b.length, n = b[0].length;
        boolean[][] v = new boolean[m][n];

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
                    if (b[x][y] == 'O' && v[x][y] == false) {
                        dfs(x, y, v, m, n, b);
                    }
                }
            }
        }

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (b[x][y] == 'O' && v[x][y] == false) b[x][y] = 'X';
            }
        }

        // for (boolean[] c : v) {
        //     System.out.println(Arrays.toString(c));
        // }
    }

    private void dfs (int x, int y, boolean[][] v, int m, int n, char[][] b) {
        if (x >= m || x < 0 || y >= n || y < 0 || v[x][y] == true || b[x][y] != 'O') return;

        v[x][y] = true;

        //Up
        dfs (x - 1, y, v, m, n, b);
        dfs (x + 1, y, v, m, n, b);
        dfs (x, y - 1, v, m, n, b);
        dfs (x, y + 1, v, m, n, b);

        return;
    }
}