class Solution {
    public int rotatedDigits(int n) {
        int c = 0;
        for (int x = 1; x <= n; x++) if (isGood(x)) c++;

        return c;
    }

    private boolean isGood(int x) {
        boolean changed = false;
        while (x > 0) {
            int digit = x % 10;
            if (digit == 3 || digit == 4 || digit == 7) return false;
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) changed = true;

            x /= 10;
        }

        return changed;
    }
}