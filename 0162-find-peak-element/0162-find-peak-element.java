class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        for (int x = 1; x < nums.length - 1; x++) {
            if (nums[x] > nums[x - 1] && nums[x] > nums[x + 1]) return x;
        }
        return nums[0] > nums[1] ? 0 : nums.length - 1;
    }
}