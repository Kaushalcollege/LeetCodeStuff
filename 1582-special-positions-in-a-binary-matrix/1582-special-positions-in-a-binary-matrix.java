class Solution {
    public int numSpecial(int[][] mat) {
        int sc = 0;

        // for (int i = 0; i < mat.length; i++) {
        //     for (int j = 0; j < mat[0].length; j++) {
        //         if (mat[i][j] == 1) rc++;
        //     }
        //     if (rc == 1 and) {
        //         sc++;
        //         rc = 0;
        //     }
        // }

        int[] rc = new int[mat.length];
        int[] cc = new int[mat[0].length];

        // for (int i = 0; i < mat.length; i++) {
        //     for (int j = 0; j < mat[0].length; j++) {
        //         if (mat[i][j] == 1) rc[i]++;
        //     }
        // }
        
        // for (int i = 0; i < mat.length; i++) {
        //     for (int j = 0; j < mat[0].length; j++) {
        //         if (mat[j][i] == 1) cc[i]++;
        //     }
        // }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    rc[i]++;
                    cc[j]++;
                }
            }
        }

        // System.out.println(Arrays.toString(rc));
        // System.out.println(Arrays.toString(cc));
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && rc[i] == 1 && cc[j] == 1) sc++;
            }
        }

        return sc;
    }
}