from typing import List

class Solution:
    def triangularSum(self, nums: List[int]) -> int:
        """
            -- we are initially given an array of length n.
            -- We are to find out the triangular sum of the array.
            -- The triangular sum of nums is the value of the only element present in nums after the following process terminates:
                -- Let nums comprise of n elements. If n == 1, end the process. Otherwise, create a new 0-indexed integer array newNums of length n - 1.
                -- For each index i, where 0 <= i < n - 1, assign the value of newNums[i] as (nums[i] + nums[i+1]) % 10, where % denotes modulo operator.
                -- Replace the array nums with newNums.
                -- Repeat the entire process starting from step 1.
                -- return the triangular sum of nums.

                -- the space complexity will be O(n) as we are creating a new array newNums.
        """
        n = len(nums)

        # This is O(1) space and O(n^2) time complexity
        while n > 1:
            for i in range(n - 1):
                nums[i] = (nums[i] + nums[i+1]) % 10
            n -= 1

        return nums[0]
