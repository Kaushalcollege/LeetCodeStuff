class Solution {
    public double angleClock(int hour, int minutes) {
        /*
            -- Microsoft SDE Intern PYQ.
            -- What should be done exactly?
            -- Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.

            -- Answers within 10^5 of the actual value will be accepted as correct.
            -- The fact is that, it is really simple.
            -- To put it into words, suppose the time is 12 : 30.
            -- The minute hand is at 6 and hour hand is exactly in the middle of 12 and 1.
            -- If we assume the 360 / 12 == 30 deg.
            -- Since the hour hand is exactly between 12 and 1 it has already covered 15 deg from origin.
            -- And minute hand has covered 180 deg. so angle = Math.abs(cover(min) - cover(hour)).
            -- To put that into code, we can create a covered() function which will return the degress covered by both. or no need.
            -- to execute this we have to structure our code in a neat manner.

        */

        System.out.println(minCovered(minutes));
        System.out.println(hourCovered(hour));

        double hourAngle = hourCovered(hour);
        double minAngle = minCovered(minutes);

        if (minAngle > 0){
            hourAngle += (minAngle / 360) * 30;
        }

        if (Math.abs(minAngle - hourAngle) > 180.0) return 360 - Math.abs(minAngle - hourAngle);

        return Math.abs(minAngle - hourAngle);
    }

    private double minCovered (int m){
        // if (((double)m / 60) * 360 == )
        return ((double)m / 60) * 360;
    }

    private double hourCovered (int h){
        if (((double)h / 12) * 360 == 360) return 0;
        return ((double)h / 12) * 360;
    }
}