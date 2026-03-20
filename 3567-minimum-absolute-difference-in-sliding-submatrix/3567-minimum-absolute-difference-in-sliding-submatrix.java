class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];
        if (k == 1) return ans;

        for (int i = 0; i < m - k + 1; i++) {
            for (int j = 0; j < n - k + 1; j++) {
                List<Integer> subMatrix = new ArrayList<>();
                // int[] subMatrix = new int[k * k];
                // Set<Integer> subMatrix = new HashSet<>();
                // int idx = 0;
                for (int l = i; l < i + k; l++) {
                    for (int z = j; z < j + k; z++) {
                        subMatrix.add(grid[l][z]);
                        // subMatrix[idx++] = grid[l][z];
                    }
                }
                // List<Integer> subMatrixList = new ArrayList<>(subMatrix);
                Collections.sort(subMatrix);
                // Collections.sort(subMatrixList);
                int min = 2000000;
                for (int l = 1; l < subMatrix.size(); l++) {
                    if (subMatrix.get(l).equals(subMatrix.get(l - 1))) continue;
                    min = Math.min(min, Math.abs(subMatrix.get(l) - subMatrix.get(l - 1)));
                }
                ans[i][j] = (min == 2000000) ? 0 : min;
            }
        }
        return ans;
    }
}