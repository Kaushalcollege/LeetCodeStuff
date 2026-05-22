class Solution {
    public int search(int[] nums, int target) {
        int idx = -1;
        for (int x = 0; x < nums.length; x++) if (nums[x] == target) idx = x;

        return idx;
    }
}