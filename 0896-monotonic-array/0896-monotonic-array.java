class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean dec = true, asc = true;
        for (int i = 0; i < nums.length - 1; ++i){
            if (nums[i] < nums[i + 1]) dec = false;
            else if (nums[i] > nums[i + 1]) asc = false;
        }
        return asc || dec;
    }
}