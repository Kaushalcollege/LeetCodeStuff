class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        for (int i = 0; i + 2 * k <= n; i++) {
            boolean firstInc = true, secondInc = true;

            // check if first subarray [i, i + k) is increasing
            for (int j = i + 1; j < i + k; j++) {
                if (nums.get(j) <= nums.get(j - 1)) {
                    firstInc = false;
                    break;
                }
            }

            // check if second subarray [i + k, i + 2k) is increasing
            for (int j = i + k + 1; j < i + 2 * k; j++) {
                if (nums.get(j) <= nums.get(j - 1)) {
                    secondInc = false;
                    break;
                }
            }

            if (firstInc && secondInc) return true;
        }

        return false;
    }
}
