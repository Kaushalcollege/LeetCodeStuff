class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        int startRow = 0, endRow = m - 1;
        int startCol = 0, endCol = n - 1;

        while (startRow < endRow && startCol < endCol) {

            int perimeter =
                    2 * (endRow - startRow + endCol - startCol);

            int w = k % perimeter;

            while (w-- > 0) {

                int temp = grid[startRow][startCol];

                // top row
                for (int j = startCol; j < endCol; j++) {
                    grid[startRow][j] = grid[startRow][j + 1];
                }

                // right col
                for (int i = startRow; i < endRow; i++) {
                    grid[i][endCol] = grid[i + 1][endCol];
                }

                // bottom row
                for (int j = endCol; j > startCol; j--) {
                    grid[endRow][j] = grid[endRow][j - 1];
                }

                // left col
                for (int i = endRow; i > startRow + 1; i--) {
                    grid[i][startCol] = grid[i - 1][startCol];
                }

                grid[startRow + 1][startCol] = temp;
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return grid;
    }
}