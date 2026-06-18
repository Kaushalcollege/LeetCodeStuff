class Solution {
    public double angleClock(int hour, int minutes) {
        // At 12 we are to assume that is 0 deg angle.

        if (hour == 12) hour = 0;
        double ratio = (double)minutes / 60;
        // System.out.println(ratio);
        double actualHour = 30 * (ratio + hour);
        // System.out.println(actualHour);
        double res = Math.abs((6 * minutes) - actualHour);

        return res <= 180 ? res : 360 - res;
    }
}