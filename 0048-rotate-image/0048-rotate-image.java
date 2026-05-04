class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // It's a square matrix.
        for (int x = 0; x < n; x++) {
            for (int y = x + 1; y < n; y++) {
                // swap using bitwise XOR.
                matrix[x][y] = matrix[x][y] ^ matrix[y][x]; 
                matrix[y][x] = matrix[x][y] ^ matrix[y][x];
                matrix[x][y] = matrix[x][y] ^ matrix[y][x];
            }
        }

        // swap from alternating last.

        for (int x = 0; x < n; x++) {
            int l = 0, r = n - 1;

            while (l < r) {
                matrix[x][l] = matrix[x][l] ^ matrix[x][r]; 
                matrix[x][r] = matrix[x][l] ^ matrix[x][r];
                matrix[x][l] = matrix[x][l] ^ matrix[x][r];
                l++;
                r--;
            }
        }

        return;
    }
}