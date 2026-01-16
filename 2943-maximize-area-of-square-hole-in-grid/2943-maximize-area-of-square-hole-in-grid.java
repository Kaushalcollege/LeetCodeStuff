class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int i = 0, j = 0, h = 1, v = 1;
        int mH = 1, mV = 1;
        while (i < hBars.length - 1 || j < vBars.length - 1) {
            if (i < hBars.length - 1) {
                if (hBars[i + 1] - hBars[i] == 1) h++;
                else {
                    mH = Math.max(mH, h);
                    h = 1;
                }
                i++;
            }

            if (j < vBars.length - 1) {
                if (vBars[j + 1] - vBars[j] == 1) v++;
                else {
                    mV = Math.max(mV, v);
                    v = 1;
                }
                j++;
            }
        }
        mH = Math.max(mH, h);
        mV = Math.max(mV, v);
        int side = Math.min(mH + 1, mV + 1);
        return side * side;
    }
}