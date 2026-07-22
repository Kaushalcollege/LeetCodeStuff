class Solution {
    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1, ptr = 1;
        int[][] res = new int[n][n];

        while(ptr < (n * n) + 1) {
            // l to r ::
            for (int x = l; x <= r; x++) {
                res[t][x] = ptr;
                ptr++;
            }
            t++;
            for (int x = t; x <= b; x++) {
                res[x][r] = ptr;
                ptr++;
            }
            r--;
            for (int x = r; x >= l; x--) {
                res[b][x] = ptr;
                ptr++;
            }
            b--;
            for (int x = b; x >= t; x--) {
                res[x][l] = ptr;
                ptr++;
            }
            l++;
        }

        return res;
    }
}