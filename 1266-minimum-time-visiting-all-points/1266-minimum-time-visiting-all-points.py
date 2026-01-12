class Solution:
    def minTimeToVisitAllPoints(self, p: List[List[int]]) -> int:
        mini = 0

        for i in range (0, len(p) - 1) :
            x, y = p[i]
            X, Y = p[i + 1]
            if (abs(X - x) > abs(Y - y)) : mini += abs(X - x)
            else : mini += abs(Y - y)


        return mini