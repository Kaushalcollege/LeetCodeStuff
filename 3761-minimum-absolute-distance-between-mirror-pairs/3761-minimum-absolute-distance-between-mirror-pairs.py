class Solution:
    def minMirrorPairDistance(self, nums: List[int]) -> int:
        n = len(nums)
        map: Dict[int, int] = {}
        ans = n + 1

        for x, ele in enumerate(nums):
            rev_ele = self.rev(ele)

            if ele in map:
                ans = min(ans, x - map[ele])

            map[rev_ele] = x

        return -1 if ans == n + 1 else ans

    def rev(self, x: int) -> int:
        r = 0

        while x > 0:
            r = r * 10 + x % 10
            x //= 10

        return r