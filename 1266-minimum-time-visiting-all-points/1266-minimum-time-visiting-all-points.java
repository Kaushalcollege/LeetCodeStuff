class Solution {
    public int minTimeToVisitAllPoints(int[][] p) {
        int min = 0;
        for (int i = 0; i < p.length - 1; i++) {
            int x = p[i][0];
            int y = p[i][1];
            int X = p[i + 1][0];
            int Y = p[i + 1][1];
            min += Math.max(Math.abs(X - x), Math.abs(Y - y));
        }

        return min;
    }
}