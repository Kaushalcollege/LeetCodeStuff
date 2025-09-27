class Solution {
    public double largestTriangleArea(int[][] points) {
        /*
            -- How does one find the area of the triangle?
            -- If it is a right-angled triangle -- 0.5 * base * height.
            -- Or heron's formula if the sides are given.
            -- Or when coordinates are given -- 0.5 * {x1(y2 - y3) + x2(y3 - y1) + x3(y1 - y2)}.
            -- so we will create a function called double areaOfTriangle (int[] one, int[] two, int[] three).

            -- since there are only max 50 points, brute force can be used.

            -- Triple nested loop.
        */

        double maxArea = 0;
        double area = 0;

        for (int i = 0; i < points.length; i++){
            for (int j = i + 1; j < points.length; j++){
                for (int k = j + 1; k < points.length; k++){
                    area = areaOfTriangle(points[i], points[j], points[k]);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;

    }

    private double areaOfTriangle (int[] one, int[] two, int[] three){
        return 0.5 * Math.abs((one[0]*(two[1] - three[1]) + two[0]*(three[1] - one[1]) + three[0]*(one[1] - two[1])));
    }
}