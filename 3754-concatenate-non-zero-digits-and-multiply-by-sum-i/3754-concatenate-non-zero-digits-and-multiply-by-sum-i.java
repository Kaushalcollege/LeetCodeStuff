class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0, actual = 0;
        int place = 0;
        while (n > 0) {
            int dig = n % 10;
            if (dig == 0) {
                n /= 10;
                continue;
            }
            sum += dig;
            actual += Math.pow(10, place) * dig;
            System.out.println(actual);
            place++;
            n /= 10;
        }

        return sum * actual;
    }
}