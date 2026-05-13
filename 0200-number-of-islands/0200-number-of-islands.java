class Solution {
    public int numIslands(char[][] grid) {
        // No need of adjacency list.

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        int cnt = 0;

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == '1' && vis[x][y] == false) {
                    cnt++;
                    dfs (grid, vis, x, y, m, n);
                }
            }
        }

        return cnt;
    }


    private void dfs (char[][] grid, boolean[][] v, int x, int y, int m, int n) {
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == '0' || v[x][y]) return;

        v[x][y] = true;

        //Up
        dfs (grid, v, x - 1, y, m, n);
        //Down
        dfs (grid, v, x + 1, y, m, n);
        //right
        dfs (grid, v, x, y + 1, m, n);
        //left
        dfs (grid, v, x, y - 1, m, n);

        return;
    }
}