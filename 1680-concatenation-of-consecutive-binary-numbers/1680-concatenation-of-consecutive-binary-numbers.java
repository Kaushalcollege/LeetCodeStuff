class Solution {
    public int concatenatedBinary(int n) {
        int MOD = 1_000_000_007;
        long result = 0;
        int bitLength = 0;

        for (int i = 1; i <= n; i++) {
            // increase bit length when i is power of 2
            if ((i & (i - 1)) == 0) {
                bitLength++;
            }

            result = ((result << bitLength) % MOD + i) % MOD;
        }

        return (int) result;
    }
}