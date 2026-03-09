class Solution {
    long[][][][] dp;
    int MOD = 1000000007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        dp = new long[zero + 1][one + 1][3][limit + 1];
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                for (int k = 0; k < 3; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

        long ans = solve (zero, one, 2, 0, limit);

        return (int) (ans % MOD);
    }

    private long solve (int zero, int one, int conEl, int count, int limit) {
        if (zero == 0 && one == 0) return 1;

        if (dp[zero][one][conEl][count] != -1) return dp[zero][one][conEl][count];

        long ans = 0;
        if (zero > 0) {
            if (conEl == 0 && count < limit) ans = (ans + solve (zero - 1, one, 0, count + 1, limit)) % MOD;
            else if (conEl == 1 || conEl == 2) ans = (ans + solve (zero - 1, one, 0, 1, limit)) % MOD;
        }

        if (one > 0) {
            if (conEl == 1 && count < limit) ans = (ans + solve (zero, one - 1, 1, count + 1, limit)) % MOD;
            else if (conEl == 0 || conEl == 2) ans = (ans + solve (zero, one - 1, 1, 1, limit)) % MOD;
        }

        return dp[zero][one][conEl][count] = ans % MOD;
    }
}