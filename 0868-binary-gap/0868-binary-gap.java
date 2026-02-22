class Solution {
    public int binaryGap(int n) {
        String bin = Integer.toBinaryString(n);
        int prev = 0, curr = -1, max = 0;

        for (int i = 1; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') {
                curr = i;
                max = Math.max(curr - prev, max);
                prev = curr;
            }
        }

        return max;
    }
}