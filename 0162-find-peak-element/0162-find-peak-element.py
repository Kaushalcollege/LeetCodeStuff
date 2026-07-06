class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) == 1 : return 0
        for x in range(1, len(nums) - 1) :
            if (nums[x] > nums[x - 1] and nums[x] > nums[x + 1]) :
                return x

        return 0 if nums[0] > nums[1] else len(nums) - 1