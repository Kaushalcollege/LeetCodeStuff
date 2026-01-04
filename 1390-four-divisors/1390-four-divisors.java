class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;

        for (int i : nums) {
            int val = divisor(i)[0];
            if (val == 4) sum += divisor(i)[1];
        }

        return sum;
    }

    private int[] divisor (int n) {
        // System.out.println(n);
        int total = 1 + n;
        int i = 2;
        int r = 2;
        while (i * i <= n) {
            if (n % i == 0) {
                r += 2;
                total += i;
                total += n / i;
                if (i * i == n) {
                    r -= 1;
                    total -= i;
                }
            }
            i++;
        }

        return new int[] {r, total};
    }
}