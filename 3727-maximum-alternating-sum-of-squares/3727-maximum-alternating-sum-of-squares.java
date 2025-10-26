import java.util.*;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) 
            nums[i] = Math.abs(nums[i]);
        
        Arrays.sort(nums); // ascending order
        
        int l = 0, r = nums.length - 1;
        int[] res = new int[nums.length];
        int idx = 0;
        
        // rearrange: max, min, 2nd max, 2nd min, ...
        while (l <= r) {
            if (idx % 2 == 0)
                res[idx++] = nums[r--];
            else
                res[idx++] = nums[l++];
        }

        long sum = 0;
        for (int i = 0; i < res.length; i++) {
            long sq = (long) res[i] * res[i];
            if (i % 2 == 0) sum += sq;
            else sum -= sq;
        }
        return sum;
    }
}
