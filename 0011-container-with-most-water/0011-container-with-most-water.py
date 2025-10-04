from typing import List

class Solution:
    def maxArea(self, height: List[int]) -> int:
        ma = 0
        l, r = 0, len(height) - 1
        while l < r:
            ca = min(height[l], height[r]) * (r - l)
            ma = max(ma, ca)
            if height[l] < height[r]:
                l += 1
            else:
                r -= 1
        return ma
