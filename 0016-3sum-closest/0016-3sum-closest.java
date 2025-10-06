import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE / 2; // to avoid overflow

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                // update closestSum if this sum is closer to target
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                // move pointers
                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    // exact match — can’t get closer
                    return sum;
                }
            }
        }

        return closestSum;
    }
}
