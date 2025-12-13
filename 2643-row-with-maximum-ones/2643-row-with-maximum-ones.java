class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] rows = new int[mat.length];

        for (int i = 0; i < mat.length; i++) {
            int rowCount = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) rowCount++;
            }
            rows[i] = rowCount;
        }

        int[] res = new int[2];
        for (int i = 0; i < rows.length; i++){
            if (rows[i] > res[1]) {
                res[0] = i;
                res[1] = rows[i];
            }
            if (rows[i] == res[1]) {
                res[0] = Math.min(res[0], i);
            }
        }
        return res;
    }
}