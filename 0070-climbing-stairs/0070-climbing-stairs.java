class Solution {
    public static Map<Integer, Integer> memoization = new HashMap<>();
    public int climbStairs(int n) {
        /*
            -- Most basic implementation of Dynamic Programming.
            -- Top-Down (Naive), Top-Down(Memoization), Bottom-Up (Tabulation).
            -- Let us look at the problm more deeply:-
            -- Top-Down Naive solution is just recursion.
            -- whenver n == 1 or 0 return 1.

            -- Top-Down Memoization is tricky.
            -- Declare a static memo data structure.
        */

        // Top-down (Naive)
        // the total number of ways are -- first only one step + first only two steps.
        // when n == 1 there is only 1 way to climb the stairs, so return 1.

        // if (n <= 1) return 1;
        // return climbStairs(n - 1) + climbStairs(n - 2);

        // Top-Down memo:-

        if (memoization.containsKey(n)) return memoization.get(n);
        int res;

        if (n <= 1) res = 1;
        else res = climbStairs(n - 1) + climbStairs(n - 2);

        memoization.put(n, res);
        return res;
    }
}