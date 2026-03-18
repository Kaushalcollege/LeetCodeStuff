class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        // for (int[] i : grid) System.out.println(Arrays.toString(i));
        // System.out.println("==============================");
        int count = 0;
        // First Row ::
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i - 1];
            if (grid[0][i] <= k) count++;
        }
        // First Column ::
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
            if (grid[i][0] <= k) count++;
        }
        // int inner_sum = 0;
        // System.out.println("==============================");

        // for (int[] i : grid) System.out.println(Arrays.toString(i));

        // Inner Matrices ::
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                // inner_sum += (grid[i - 1][j] + grid[i][j] + grid[i][j - 1] - grid[0][0]);
                // grid[i][j] = inner_sum;
                // System.out.println(inner_sum);
                // if (inner_sum <= k) count++;
                // // else break;
                grid[i][j] = grid[i][j] + grid[i - 1][j] + grid[i][j - 1] - grid[i - 1][j - 1];
                if (grid[i][j] <= k) count++;
            }
        }

        // for (int[] i : grid) System.out.println(Arrays.toString(i));

        return (grid[0][0] <= k) ? count + 1 : count;
    }
}