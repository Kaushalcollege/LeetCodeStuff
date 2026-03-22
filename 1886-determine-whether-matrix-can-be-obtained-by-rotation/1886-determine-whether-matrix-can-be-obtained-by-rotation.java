class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        // int[][] ck = new int[n][n];

        /*
            if n == 3 :
            0   0   0          0   0   0
            0   0   0          0   1   0
            0   0   0  <- i -> 1   1   1
                               ^
                               j
        */

        for (int r = 0; r < 4; r++) {
            if (isSame(mat, target)) return true;

            int[][] ck = new int[n][n];

            for (int i = n - 1; i >= 0; i--) { 
                for (int j = 0; j < n; j++) { 
                    ck[n - j - 1][n - i - 1] = mat[i][n - j - 1]; 
                } 
            }

            mat = ck; 
        }

        return false;
    }

    private boolean isSame(int[][] a, int[][] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }
}