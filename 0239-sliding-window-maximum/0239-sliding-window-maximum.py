class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        """
            -- Very General sliding window application.
            -- Start from left ptr = 0 and right ptr = k - 1.
            -- We have to add the max element of all the sub arrays into List.
            -- We have to use deque.
        """

        if len(nums) == 1:
            return [nums[0]]

        n = len(nums)
        res = []
        dq = deque()

        for i in range(n):
            # Remove indices that are out of this window
            while dq and dq[0] <= i - k:
                dq.popleft()

            # Remove elements smaller than current (not useful)
            while dq and nums[dq[-1]] <= nums[i]:
                dq.pop()

            dq.append(i)

            # Add to result once we reach size k
            if i >= k - 1:
                res.append(nums[dq[0]])

        return res