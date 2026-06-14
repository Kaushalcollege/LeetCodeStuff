class Solution {
    public int trap(int[] height) {
        int n = height.length, total = 0;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];

        prefixMax[0] = height[0];
        for (int x = 1; x < n; x++) prefixMax[x] = Math.max(prefixMax[x - 1], height[x]);
        suffixMax[n - 1] = height[n - 1];
        for (int x = n - 2; x >= 0; x--) suffixMax[x] = Math.max(suffixMax[x + 1], height[x]);

        for (int x = 0; x < n; x++) {
            if (height[x] < prefixMax[x] && height[x] < suffixMax[x]) total += Math.min(prefixMax[x], suffixMax[x]) - height[x];
        }

        return total;
    }
}