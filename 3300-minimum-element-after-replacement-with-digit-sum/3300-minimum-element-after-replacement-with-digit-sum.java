class Solution {
    public int minElement(int[] nums) {
        int min = 10001;

        for (int x : nums) min = Math.min(min, digitSum(x));

        return min;
    }
    private int digitSum (int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}