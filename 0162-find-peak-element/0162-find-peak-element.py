class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) == 1 : return 0
        if nums[0] > nums[1] : return 0
        if nums[len(nums) - 1] > nums[len(nums) - 2] : return len(nums) - 1

        x, y = 0, len(nums) - 1
        while x <= y :
            mid = int(x + (y - x) / 2)
            if (nums[mid] > nums[mid + 1] and nums[mid] > nums[mid - 1]) : return mid
            elif (nums[mid] < nums[mid + 1] and nums[mid] > nums[mid - 1]) : x = mid + 1
            else : y = mid

        return 0 if nums[0] > nums[1] else len(nums) - 1