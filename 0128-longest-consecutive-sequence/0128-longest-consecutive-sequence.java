class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 0) return n;
        int lastSmallest = Integer.MIN_VALUE, longest = 1, curr = 0;

        for (int x = 0; x < n; x++) {
            if (nums[x] - 1 == lastSmallest) {
                curr += 1;
                lastSmallest = nums[x];
            }
            else if (nums[x] != lastSmallest) {
                curr = 1;
                lastSmallest = nums[x];
            }

            longest = Math.max(longest, curr);
        }

        return longest;
    }
}