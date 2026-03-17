class Solution {
    public int largestSubmatrix(int[][] matrix) {
        /*

        -- >        0   0   1       0   0   1       1   0   0
                    1   1   1   --> 1   1   2   --> 2   1   1
                    1   0   1       2   0   3       3   2   0

                    area, should be taken --> 1. width == 1
                                                 height == 2 == 2
                                              2. width == 2
                                                 height == 2
        */

        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < n; i++) {
            boolean start = false;
            int count = 0;
            for (int j = 0; j < m; j++) {
                // int count = 1;
                if (matrix[j][i] == 1 && start == false) {
                    start = true;
                    count = 1;
                }
                else if (matrix[j][i] == 1 && start == true) {
                    count += 1;
                    matrix[j][i] = count;
                }
                else if (matrix[j][i] != 1 && start == true) {
                    start = false;
                    count = 0;
                }
            }
        }
        // for (int[] i : matrix) System.out.println(Arrays.toString(i));
        for (int i = 0; i < m; i++) {
            mergeSort(matrix[i], 0, n - 1);
        }

        // for (int[] i : matrix) System.out.println(Arrays.toString(i));
        int a = 0, ma = -1;

        for (int w = 0; w < n; w++) {
            // a = w * matrix[matrix.length - 1][w - 1];
            // ma = Math.max(ma, a);
            int max = 0;
            for (int i = matrix.length - 1; i >= 0; i--) max = Math.max(matrix[i][w], max);
            a = (w + 1) * max;
            // System.out.println(a + " " + w + " " + max);
            ma = Math.max(ma, a);
        }

        return ma;
    }


    private void mergeSort(int arr[], int l, int r){
        
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    private void merge(int arr[], int l, int m, int r){
        
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}