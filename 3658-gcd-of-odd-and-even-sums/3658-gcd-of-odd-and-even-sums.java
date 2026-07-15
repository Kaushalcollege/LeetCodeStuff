class Solution {
    public int gcdOfOddEvenSums(int n) {
        int odd = 1, sumOdd = 0, even = 0, sumEven = 0;
        for (int x = 0; x < n; x++) {
            odd += 2;
            sumOdd += odd;
            even += 2;
            sumEven += even;
        }
        // System.out.println(sumOdd + " " + sumEven);

        return gcd(sumOdd, sumEven);
    }

    private int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }
}