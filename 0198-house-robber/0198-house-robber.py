class Solution:
    def rob(self, nums: List[int]) -> int:
        # memo = []
        memo = [-1] * len(nums)
        return self.func(nums, 0, memo)

    def func (self, arr : List[int], idx : int, dp : List[int]) -> int:

        if (idx >= len(arr)) : return 0

        if (idx == len(arr) - 1) :
            dp[idx] = arr[idx]
            return dp[idx]

        if (dp[idx] != -1) : return dp[idx]

        pick = arr[idx] + self.func(arr, idx + 2, dp)
        notPick = self.func(arr, idx + 1, dp)
        dp[idx] = max(pick, notPick)

        return dp[idx]