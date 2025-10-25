class Solution {
    public int findPeakElement(int[] nums) {
        int i = 0, j = nums.length - 1;
        if (nums.length == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 2] < nums[nums.length - 1]) return nums.length - 1;

        while(i <= j) 
        {
            int mid = (i + j) / 2; 
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) return mid;
            if( nums[mid] < nums[mid + 1] && nums[mid] > nums[mid - 1]) i = mid + 1;
            else j = mid;

        }
        return nums[0] > nums[nums.length - 1] ? 0 : nums.length -1;
    }
}