class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        if (n == 1) return new int[]{-1};

        int[] res = new int[n];
        res[n - 1] = -1;
        // res[n - 2] = arr[n - 1];

        for (int x = n - 1; x > 0; x--) {
            if (arr[x] >= res[x]) res[x - 1] = arr[x];
            else res[x - 1] = res[x];
        }

        return res;
    }
}