class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int ptr = 1;
        for (int i = x; i < x + k / 2; i++) {
            int[] curr = new int[k];
            int idx = 0;
            int[] last = new int[k];
            for (int j = y; j < y + k; j++) {
                curr[idx++] = grid[i][j];
            }
            // System.out.println(Arrays.toString(curr));
            idx = 0;
            for (int j = y; j < y + k; j++) {
                last[idx++] = grid[i + k - ptr][j];
            }
            // System.out.println(Arrays.toString(last));
            idx = 0;
            int idx1 = 0;
            for (int j = y; j < y + k; j++) {
                grid[i][j] = last[idx1++];
                grid[i + k - ptr][j] = curr[idx++];
            }
            ptr += 2;
        }

        return grid;
    }
}