class Solution {
    public long maxMatrixSum(int[][] matrix) {
        // We will be getting only square matrices.
        int n = matrix.length;
        long total = 0;
        int min = Integer.MAX_VALUE;
        int neg = 0;
        // int[] count = new int[n];

        // Arrays.sort(matrix, new Comparator<int[]>() {
        //     public int compare (int[] a, int[] b) {return a[1]}
        // });
        // for (int i = 0; i < n; i++) {
        //     Arrays.sort(matrix[i]);
        // }

        // StringBuilder ii = new StringBuilder();
        // // System.out.println(Arrays.toString(row));
        // for (int[] row : matrix) {
        //     ii.append(Arrays.toString(row)).append("\n");
        // }

        // System.out.println(ii.toString());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                total += Math.abs(val);
                if (val < 0) neg++;
                min = Math.min(min, Math.abs(val));
            }
        }

        return neg % 2 == 0 ? total : total - (2 * min);
    }
}