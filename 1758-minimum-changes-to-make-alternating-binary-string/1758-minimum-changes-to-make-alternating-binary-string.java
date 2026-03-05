class Solution {
    public int minOperations(String s) {
        StringBuilder ii = new StringBuilder(s);
        StringBuilder ij = new StringBuilder(s);
        int c = 0, fc = 0;

        char prev = s.charAt(0);
        char flippedPrev = '1';
        if (prev == '0') {
            flippedPrev = '1';
            ij.setCharAt(0, flippedPrev);
            fc++;
        }
        if (prev == '1') {
            flippedPrev = '0';
            ij.setCharAt(0, flippedPrev);
            fc++;
        }
        // char curr = '';

        for (int i = 1; i < ii.length(); i++) {
            if (ii.charAt(i) != prev) {
                prev = ii.charAt(i);
                continue;
            }
            else {
                if (prev == '0') {
                    ii.setCharAt(i, '1');
                    prev = '1';
                    c++;
                }
                else {
                    ii.setCharAt(i, '0');
                    prev = '0';
                    c++;
                }
            }
        }

        for (int i = 1; i < ii.length(); i++) {
            if (ij.charAt(i) != flippedPrev) {
                flippedPrev = ij.charAt(i);
                continue;
            }
            else {
                if (flippedPrev == '0') {
                    ij.setCharAt(i, '1');
                    flippedPrev = '1';
                    fc++;
                }
                else {
                    ij.setCharAt(i, '0');
                    flippedPrev = '0';
                    fc++;
                }
            }
        }
        System.out.println(ii.toString());
        System.out.println(ij.toString());

        return Math.min(fc, c);
    }
}