class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n - rev(n));
    }

    private int rev (int x) {
        int r = 0;

        while (x > 0) {
            r = r * 10 + x % 10;
            x /= 10;
        }
        return r;
    }
}