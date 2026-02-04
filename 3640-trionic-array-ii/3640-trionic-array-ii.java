import java.util.Arrays;

class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        final long MIN = Long.MIN_VALUE / 2;

        long[] L1 = new long[n];
        long[] L2 = new long[n];
        Arrays.fill(L2, MIN);

        for (int i = 0; i < n; i++) {
            L1[i] = nums[i];
            if (i > 0 && nums[i] > nums[i - 1]) {
                long prevMax = Math.max(L1[i - 1], L2[i - 1]);
                if (prevMax != MIN) {
                    L2[i] = nums[i] + prevMax;
                }
            }
        }

        long[] R1 = new long[n];
        long[] R2 = new long[n];
        Arrays.fill(R2, MIN);

        for (int i = n - 1; i >= 0; i--) {
            R1[i] = nums[i];
            if (i < n - 1 && nums[i] < nums[i + 1]) {
                long nextMax = Math.max(R1[i + 1], R2[i + 1]);
                if (nextMax != MIN) {
                    R2[i] = nums[i] + nextMax;
                }
            }
        }

        long[] D = new long[n];
        Arrays.fill(D, MIN);

        for (int i = 2; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                long cand1 = (L2[i - 1] == MIN) ? MIN : L2[i - 1] + nums[i];
                long cand2 = (D[i - 1] == MIN) ? MIN : D[i - 1] + nums[i];
                D[i] = Math.max(cand1, cand2);
            }
        }

        long maxSum = MIN;

        for (int q = 2; q < n - 1; q++) {
            if (D[q] != MIN && R2[q] != MIN) {
                long currentSum = D[q] - nums[q] + R2[q];
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}
