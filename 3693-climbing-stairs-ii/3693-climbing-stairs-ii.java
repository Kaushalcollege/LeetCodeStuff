class Solution {
    public int climbStairs(int n, int[] costs) {
        // Pad costs to make it 1-indexed
        int[] newCosts = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            newCosts[i] = costs[i - 1];
        }

        Integer[] memo = new Integer[n + 1];
        return dfs(n, newCosts, memo);
    }

    private int dfs(int i, int[] costs, Integer[] memo) {
        if (i == 0) return 0;                 // base case
        if (i < 0) return Integer.MAX_VALUE;  // invalid state
        if (memo[i] != null) return memo[i];  // memoized

        int best = Integer.MAX_VALUE;

        // from i-1
        if (i - 1 >= 0) {
            best = Math.min(best, dfs(i - 1, costs, memo) + costs[i] + 1);
        }
        // from i-2
        if (i - 2 >= 0) {
            best = Math.min(best, dfs(i - 2, costs, memo) + costs[i] + 4);
        }
        // from i-3
        if (i - 3 >= 0) {
            best = Math.min(best, dfs(i - 3, costs, memo) + costs[i] + 9);
        }

        return memo[i] = best;
    }
}
