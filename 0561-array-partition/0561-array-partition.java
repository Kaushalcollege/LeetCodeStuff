class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;

        // while (l < r) {
        //     // int min = Math.min(nums[l], nums[r]);
        //     sum += Math.min(nums[l], nums[r]);
        //     l++;
        //     r--;
        // }
        for (int x = 0; x < n - 1; x += 2) sum += Math.min(nums[x], nums[x + 1]);

        return sum;
    }
}