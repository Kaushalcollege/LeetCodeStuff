class Solution {
    public void solve(char[][] grid) {
        int m = grid.length, n = grid3[0].length;
        boolean[][] v = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int x = 0; x < m; x++) for (int y = 0; y < n; y++) if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
            if (grid[x][y] == 'O') {
                q.add(new int[]{x, y});
                v[x][y] = true;
            }
        }

        while(!q.isEmpty()) {
            int[] coordinates = q.poll();

            for (int x = 0; x < 4; x++) {
                int r = coordinates[0] + dr[x];
                int c = coordinates[1] + dc[x];

                if (r >= 0 && r < m && c >= 0 && c < n && !v[r][c] && grid[r][c] == 'O') {
                    q.add(new int[]{r, c});
                    v[r][c] = true;
                }
            }
        }

        for (int x = 0; x < m; x++) for (int y = 0; y < n; y++) if (grid[x][y] == 'O' && !v[x][y]) grid[x][y] = 'X';

        return;
    }
}