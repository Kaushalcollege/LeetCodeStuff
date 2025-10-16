class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        /*
            -- Given:
            -- An int[] nums and an integer value.
            -- In one operation, we can either subtract or add "value" to any element of nums.
            -- For example, if nums = [1,2,3] and value = 2, you can choose to subtract value from nums[0] to make nums = [-1,2,3].
            -- The MEX (minimum excluded) of an array is the smallest missing non-negative integer in it.
            -- For example, the MEX of [-1,2,3] is 0 while the MEX of [1,0,3] is 2.
            -- We have to return the maximum MEX of nums after applying the mentioned operation any number of times.
        */
        int n = nums.length, res = 0;
        int[] rem = new int[value];
        for (int x : nums) {
            int r = ((x % value) + value) % value;
            rem[r]++;
        }
        while (rem[res % value]-- > 0) res++;
        return res;
    }
}