class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;

        while (l < r) {
            while(nums[l] == nums[r] && r > 0) r--;
            if (nums[l] < nums[r]) return nums[l];

            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[r]) l = mid + 1;
            // else if (nums[l] == nums[r] && nums[l] == nums[mid]) return nums[mid];
            else r = mid;
        }

        return nums[l];
    }
}