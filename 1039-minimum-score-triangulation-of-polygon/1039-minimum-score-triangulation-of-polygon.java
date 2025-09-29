class Solution {
    public int minScoreTriangulation(int[] values) {
        /*
            -- What should be done here?
            -- We are given a convex n - sided polygon where each vertex has an integer value.
            -- In parametric terms we are given array called values where values[i] = integer at vertex i. (CW order)
            -- Polygon triangulation is a process where you divide a polygon into a set of triangles and the vertices of each triangle must also be vertices of the original polygon.
            -- This process will result in n - 2 triangles.
            -- For each triangle, the weight of that triangle is the product of the values at its vertices.
            -- The total score of the triangulation is the sum of these weights over all n - 2 triangles.
            -- We need to return the minimum possible total score that can be achieved with some triangulation of the polygon.

            -- Example 1:
                -- Input: values = [1,2,3]
                -- Output: 6
                -- Explanation: The polygon is already triangulated, and the score is 1 * 2 * 3 = 6.

            -- Example 2:
                -- Input: values = [3,7,4,5]
                -- Output: 144
                -- Explanation: There are two triangulations, with possible scores:
                    -- 3 * 7 * 4 + 3 * 4 * 5 = 84 + 60 = 144
                    -- 3 * 7 * 5 + 7 * 4 * 5 = 105 + 140 = 245
                -- The minimum score is 144.
            
            -- How do we go about solving this?
            -- The constraints are small enough to allow for a O(n^3) solution.
            -- n == values.length
            -- 3 <= n <= 50
            -- 1 <= values[i] <= 100

        */

        int n = values.length;
        int[][] dp = new int[n][n];

        // length is the size of sub-polygon
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i][k] + dp[k][j] + values[i] * values[k] * values[j]
                    );
                }
            }
        }

        return dp[0][n - 1];
    }
}