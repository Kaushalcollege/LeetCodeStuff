class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        int res = f(n, memo);
        return res;
    }

    private int f (int n, int[] m) {
        if (n == 0 || n == 1) return 1;
        if (m[n] != -1) return m[n];

        return m[n] = f(n - 1, m) + f(n - 2, m);
    }
}