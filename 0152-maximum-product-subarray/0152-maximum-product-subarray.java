class Solution {
    public int maxProduct(int[] nums) {
        /*
            -- How do we use DP for this?
               We track both the maximum and minimum products ending at each index.

            -- Do we have overlapping subproblems?
               Yes, because the product at index i depends on previously computed max/min values.

            -- Do we have optimal substructure?
               Yes, the optimal (max) product at i depends on optimal results from i-1.

            -- Subproblems:
               maxProd[i] = max product subarray ending at index i
               minProd[i] = min product subarray ending at index i

            -- Reason for tracking both:
               Multiplying by a negative can flip signs, turning a large min into a potential max.
        */

        int max = nums[0];
        int min = nums[0];
        int arrMax = nums[0];

        for (int i = 1; i < nums.length; i++){
            int curr = nums[i];

            if (curr < 0){
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(curr, curr * max);
            min = Math.min(curr, curr * min);

            arrMax = Math.max(max, arrMax);
        }

        return arrMax;
    }
}
