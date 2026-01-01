class NumArray {
    int[] pfx;

    public NumArray(int[] nums) {
        pfx = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) pfx[i + 1] = pfx[i] + nums[i];
    }
    
    public int sumRange(int left, int right) {
        return pfx[right + 1] - pfx[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */