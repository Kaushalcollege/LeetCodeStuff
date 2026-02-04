class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        for (int p = 1; p < n - 2; p++) {
            if (!isStrictlyIncreasing(nums, 0, p)) continue;
            for (int q = p + 1; q < n - 1; q++) {
                if (isStrictlyDecreasing(nums, p, q) && isStrictlyIncreasing(nums, q, n - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isStrictlyIncreasing(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            if (arr[i] >= arr[i + 1]) return false;
        }
        return true;
    }

    private boolean isStrictlyDecreasing(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            if (arr[i] <= arr[i + 1]) return false;
        }
        return true;
    }
}
