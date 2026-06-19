class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        n = len(gain)
        prefix = [0] * (n + 1)
        m = 0

        for x in range(1, n + 1) :
            prefix[x] = gain[x - 1] + prefix[x - 1]
            m = max(prefix[x], m)

        return m