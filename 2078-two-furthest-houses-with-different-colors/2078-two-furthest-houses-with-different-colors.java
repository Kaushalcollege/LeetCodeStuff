class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length, maxDist = 0;

        for (int x = 0; x < n - 1; x++) if (colors[x] != colors[n - 1]) {
            maxDist = Math.max(maxDist, n - 1 - x);
            break;
        }

        for (int x = n - 1; x >= 1; x--) if (colors[0] != colors[x]) {
            maxDist = Math.max(maxDist, x);
            break;
        }

        return maxDist;
    }
}