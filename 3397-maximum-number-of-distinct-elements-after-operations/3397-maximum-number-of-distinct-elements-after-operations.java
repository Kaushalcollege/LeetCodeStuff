import java.util.*;

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int lastUsed = Integer.MIN_VALUE;
        int count = 0;

        for (int num : nums) {
            // The smallest possible value we can assign ≥ (num - k)
            int candidate = Math.max(lastUsed + 1, num - k);

            // It must not exceed num + k
            if (candidate <= num + k) {
                count++;
                lastUsed = candidate;
            }
        }
        return count;
    }
}
