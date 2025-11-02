class Solution {
    public int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        
        // 1 = guard, 2 = wall
        for (int[] g : guards) grid[g[0]][g[1]] = 1;
        for (int[] w : walls) grid[w[0]][w[1]] = 2;
        
        // Mark guarded cells
        for (int[] guard : guards) {
            for (int[] d : dirs) {
                int r = guard[0] + d[0];
                int c = guard[1] + d[1];
                while (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] != 1 && grid[r][c] != 2) {
                    if (grid[r][c] == 0) grid[r][c] = 3; // mark guarded
                    r += d[0];
                    c += d[1];
                }
            }
        }

        // Count unguarded empty cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) count++;
            }
        }
        
        return count;
    }
}
