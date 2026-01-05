class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        total, mini, neg = 0, math.inf, 0

        for list in matrix :
            for i in list :
                total += abs(i)
                if i < 0 : neg += 1
                mini = min(mini, abs(i))

        # print(f"{mini} {neg}")

        return total if neg % 2 == 0 else total - (2 * mini)