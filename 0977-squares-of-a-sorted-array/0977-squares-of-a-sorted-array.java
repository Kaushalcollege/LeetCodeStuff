class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int l = 0, r = n - 1;
        int idx = n - 1;

        while (l <= r) {
            int val = 0;
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                val = nums[l];
                l++;
            }
            else {
                val = nums[r];
                r--;
            }
            res[idx--] = val * val;
        }

        return res;
    }
}