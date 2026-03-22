class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int rotation = 0;
        int n = mat.length;
        int[][] res = new int[n][n];

        while (rotation != 360) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res[j][n - i - 1] = mat[i][j];
                }
            }
            for (int i = 0; i < n; i++) {
                System.arraycopy(res[i], 0, mat[i], 0, n);
            }
            rotation += 90;
            if (Arrays.deepEquals(target, res)) return true;
        }
        return false;
    }
}