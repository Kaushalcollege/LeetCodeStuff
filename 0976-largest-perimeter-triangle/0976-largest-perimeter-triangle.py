from typing import List
class Solution:
    def largestPerimeter(self, nums: List[int]) -> int:
        """
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
        """

        nums.sort()
        for i in range(len(nums) - 1, 1, -1):
            if nums[i - 2] + nums[i - 1] > nums[i]:
                return nums[i] + nums[i - 1] + nums[i - 2]
        return 0