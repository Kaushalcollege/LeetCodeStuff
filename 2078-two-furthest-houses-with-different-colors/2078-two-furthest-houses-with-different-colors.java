class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length, max_dist = 0;
        for (int x = 0; x < n; x++) {
            for (int y = x + 1; y < n; y++) {
                if (colors[x] != colors[y]) if (y - x > max_dist) max_dist = y - x;
            }
        }

        return max_dist;
    }
}