class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        /*
            --> So, we are only travelling one-dimensionally.
            --> Our position is initially zero. L = -1, R = +1.
        */

        int farthestDist = 0, lCount = 0, rCount = 0;
        boolean lTrue = false;
        for (char c : moves.toCharArray()) {
            if (c == 'L') lCount++;
            else if (c == 'R') rCount++;
        }

        lTrue = (lCount >= rCount);

        for (char c : moves.toCharArray()) {
            if (c == 'L') farthestDist--;
            else if (c == 'R') farthestDist++;
            else {
                if (lTrue) farthestDist--;
                else farthestDist++;
            }
        }

        return Math.abs(farthestDist);
    }
}