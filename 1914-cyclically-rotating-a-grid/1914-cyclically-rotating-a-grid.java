class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int startRow = 0, endRow = m - 1, startCol = 0, endCol = n - 1;

        while (startRow < endRow && startCol < endCol) {
            int perimeter =
                    2 * (endRow - startRow + endCol - startCol);

            int w = k % perimeter;
            while (w-- > 0) {
                // top row :
            int firstRowFirstCol = grid[startRow][startCol];
            for (int x = startCol; x < endCol; x++) grid[startRow][x] = grid[startRow][x + 1];

            // first col :
            int lastRowFirstCol = grid[endRow][startCol];
            for (int x = endRow; x > startRow; x--) {
                if (x != startRow + 1) grid[x][startCol] = grid[x - 1][startCol];
                else grid[x][startCol] = firstRowFirstCol;
            }

            // last Row :
            int lastRowLastCol = grid[endRow][endCol];
            for (int x = endCol; x > startCol; x--) {
                if (x != startCol + 1) grid[endRow][x] = grid[endRow][x - 1];
                else grid[endRow][x] = lastRowFirstCol;
            }

            // last Col :
            int firstRowLastCol = grid[startRow][endCol];
            for (int x = startRow; x < endRow; x++) {
                if (x != endRow - 1) grid[x][endCol] = grid[x + 1][endCol];
                else grid[x][endCol] = lastRowLastCol;
            }
        // for (int[] g : grid) System.out.println(Arrays.toString(g));
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        // for (int[] g : grid) System.out.println(Arrays.toString(g));
        }

        // for (int[] g : grid) System.out.println(Arrays.toString(g));

        return grid;
    }
}