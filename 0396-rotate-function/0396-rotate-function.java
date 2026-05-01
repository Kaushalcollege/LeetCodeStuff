class Solution {
    public int maxRotateFunction(int[] nums) {
        int f = 0, n = nums.length, sum = 0;

        for (int x : nums) sum += x;
        // f(0)
        for (int x = 0; x < n; x++) f += x * nums[x];
        int max = f;

        for (int x = 1; x < n; x++) {
            f += (sum - (n * nums[n - x]));
            if (f > max) max = f;
        }

        return max;
    }
}