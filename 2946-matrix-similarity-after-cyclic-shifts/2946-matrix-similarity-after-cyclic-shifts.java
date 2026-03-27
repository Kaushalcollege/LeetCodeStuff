class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        if (k % mat[0].length == 0) return true;
        // return false;
        k = k % mat[0].length;
        System.out.println(k);
        int[][] ck = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            ck[i] = Arrays.copyOf(mat[i], mat[i].length);
        }
        // for (int[] row : ck) System.out.println(Arrays.toString(row));

        while (k-- > 0) {
            for (int i = 0; i < ck.length; i++) shift(ck[i], i);
            // for (int[] row : ck) System.out.println(Arrays.toString(row));
            // if (Arrays.deepEquals(mat, ck)) return true;
        }

        // return false;
        return Arrays.deepEquals(mat, ck);
    }

    private void shift (int[] arr, int idx) {
        if (idx % 2 == 0) {
            int temp = arr[0];
            for (int i = 0; i < arr.length - 1; i++) arr[i] = arr[i + 1];
            arr[arr.length - 1] = temp;
        }
        else {
            int temp = arr[arr.length - 1];
            for (int i = arr.length - 1; i > 0; i--) arr[i] = arr[i - 1];
            arr[0] = temp;
        }
    }
}