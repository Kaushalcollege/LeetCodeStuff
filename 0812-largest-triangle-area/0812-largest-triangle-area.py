class Solution:
    def largestTriangleArea(self, points: list[list[int]]) -> float:
        """
            -- How does one find the area of the triangle?
            -- If it is a right-angled triangle -- 0.5 * base * height.
            -- Or Heron's formula if the sides are given.
            -- Or when coordinates are given -- 0.5 * {x1(y2 - y3) + x2(y3 - y1) + x3(y1 - y2)}.
            -- so we will create a function called area_of_triangle(one, two, three).

            -- since there are only max 50 points, brute force can be used.

            -- Triple nested loop.
        """

        def area_of_triangle(one: list[int], two: list[int], three: list[int]) -> float:
            return 0.5 * abs(
                one[0] * (two[1] - three[1]) +
                two[0] * (three[1] - one[1]) +
                three[0] * (one[1] - two[1])
            )

        max_area = 0.0
        n = len(points)

        for i in range(n):
            for j in range(i + 1, n):
                for k in range(j + 1, n):
                    area = area_of_triangle(points[i], points[j], points[k])
                    max_area = max(max_area, area)

        return max_area
