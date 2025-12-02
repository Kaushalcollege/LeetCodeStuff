import java.util.*;

class Solution {
    public int countTrapezoids(int[][] points) {
        int MOD = 1_000_000_007;
        Map<Integer, Integer> yCount = new HashMap<>();

        for (int[] p : points) {
            yCount.put(p[1], yCount.getOrDefault(p[1], 0) + 1);
        }

        long totalPairs = 0;
        long sumOfSquares = 0;

        for (int count : yCount.values()) {
            if (count >= 2) {
                long pairs = 1L * count * (count - 1) / 2;
                totalPairs = (totalPairs + pairs) % MOD;
                sumOfSquares = (sumOfSquares + pairs * pairs % MOD) % MOD;
            }
        }

        // total trapezoids = (totalPairs * totalPairs - sumOfSquares) / 2
        long ans = (totalPairs * totalPairs % MOD - sumOfSquares + MOD) % MOD;
        ans = ans * inv(2, MOD) % MOD;
        return (int) ans;
    }

    // Modular inverse of 2 under MOD
    private long inv(long a, int mod) {
        return pow(a, mod - 2, mod);
    }

    private long pow(long a, long b, int mod) {
        long res = 1;
        a %= mod;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % mod;
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
}
