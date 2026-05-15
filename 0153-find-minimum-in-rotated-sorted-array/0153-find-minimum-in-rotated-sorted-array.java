class Solution {
    public int findMin(int[] nums) {
        // Let us find the pivot point.
        // for loop from x == 1 --> x == n - 2.

        int n = nums.length;
        int pivot = 5001;

        if (n > 3) {
            for (int x = 1; x < n - 1; x++) if (nums[x] < nums[x + 1] && nums[x] < nums[x - 1]) pivot = x;
            // pivot = pivot == -5001 ? nums[0] > nums[n - 1] ? nums[n - 1] : nums[0] : -5001;
            if (pivot == 5001) pivot = nums[0] > nums[n - 1] ? n - 1 : 0;
            return pivot == 5001 ? 5001 : nums[pivot];
        }

        for (int x = 0; x < n; x++) pivot = Math.min(pivot, nums[x]);

        return pivot;
    }
}