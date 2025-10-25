class Solution {
    public int search(int[] nums, int target) {
        // The last code was with a time complexity of O(nlogn).
        // This is with a complexity of O(logn) -- Binary Search.

        int i = 0, j = nums.length - 1, m = 0;

        while(i <= j){
            m = i + (j - i) / 2;

            if (nums[m] == target) return m;

            // left subarray (sorted).
            if (nums[i] <= nums[m]){
                if (target < nums[m] && target >= nums[i]) j = m - 1;
                else i = m + 1;
            }

            else {
                if (target > nums[m] && target <= nums[j]) i = m + 1;
                else j = m - 1;
            }
        }
        return -1;
    }
}