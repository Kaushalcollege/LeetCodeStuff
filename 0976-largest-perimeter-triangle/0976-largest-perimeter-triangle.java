class Solution {
    public int largestPerimeter(int[] nums) {
        /*
            -- We can solve this in the old fashioned way.
            -- how can we know that a triangle can be formed?
            -- if the sum of two smaller sides is greater than the third.
            -- a + b < c
            -- 3 <= nums.length <= 10^4 and 1 <= nums[i] <= 10^6 -- so brute force is out of the picture.
            -- We have to start solving in the same way as valid triangle number question.
            -- 1. sort nums
               2. after sorting, run a loop from the end till the second last side.
               3. take two pointers i and j, start i from 0 and j from (k - 1)th index.
               4. calculate the perimeter.
            -- but that is unnecessary.
            -- The triangle condition is: for three sides a ≤ b ≤ c, a triangle exists if a + b > c.

            --If you sort the array, the largest perimeter will always come from checking triples from the back (largest numbers).
            -- As soon as you find one valid triple, that’s the maximum perimeter (because any smaller numbers will only reduce the sum).
        */
        Arrays.sort(nums);
        // int maxPeri = 0, peri = 0;

        // for (int k = nums.length - 1; k >= 2; k--){
        //     int i = 0, j = k - 1;
        //     peri = 0;

        //     while(j > i){
        //         if ((nums[i] + nums[j]) > nums[k]){
        //             peri = nums[i] + nums[j] + nums[k];
        //             j--;
        //         }
        //         else i++;
        //     }
        //     maxPeri = Math.max(peri, maxPeri);
        // }
        // return maxPeri;

        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }
}