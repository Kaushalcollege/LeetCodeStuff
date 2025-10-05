class Solution {
    public static Map<Integer, Integer> memoization = new HashMap<>(); // for TDMemo.
    public int climbStairs(int n) {
        /*
            -- Most basic implementation of Dynamic Programming.
            -- Top-Down (Naive), Top-Down(Memoization), Bottom-Up (Tabulation).
            -- Let us look at the problm more deeply:-
            -- Top-Down Naive solution is just recursion.
            -- whenver n == 1 or 0 return 1.

            -- Top-Down Memoization is tricky.
            -- Declare a static memo data structure.
            -- Store each n result, when n = 1, 1
                                         n = 0, 1
                                         n = 2, 2
                                         n = 3, 3
                                         n = 4, 5
                                         so on so forth.
            -- Bottom up tabulation is nicer.
            -- Declare a DP array of size n + 1.
            -- each index within the array represents the solution to the sub problem of the solution.
        */

        // Top-down (Naive)
        // the total number of ways are -- first only one step + first only two steps.
        // when n == 1 there is only 1 way to climb the stairs, so return 1.

        // if (n <= 1) return 1;
        // return climbStairs(n - 1) + climbStairs(n - 2);

        // Top-Down memo:-

        // if (memoization.containsKey(n)) return memoization.get(n);
        // int res;

        // if (n <= 1) res = 1;
        // else res = climbStairs(n - 1) + climbStairs(n - 2);

        // memoization.put(n, res);
        // return res;

        // For Bottom - Up Tabulation -- (BUtab)

        if (n <= 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }
}