class Solution {
    public int largestAltitude(int[] gain) {
        int[] prefix = new int[gain.length + 1];
        prefix[0] = 0;
        int max = 0;

        for (int x = 1; x < prefix.length; x++) {
            prefix[x] = gain[x - 1] + prefix[x - 1];
            max = Math.max(prefix[x], max);
        }

        return max;
    }
}