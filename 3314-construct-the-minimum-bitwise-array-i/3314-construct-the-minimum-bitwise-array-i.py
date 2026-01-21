class Solution:
    def minBitwiseArray(self, nums: List[int]) -> List[int]:
        ans = [0] * len(nums)

        for i in range (len(nums)) :
            num = nums[i]

            for j in range (1, num + 1) :
                if ((j | (j + 1)) == num) :
                    ans[i] = j
                    break

            
            if ans[i] == 0 : ans[i] = -1

        
        return ans