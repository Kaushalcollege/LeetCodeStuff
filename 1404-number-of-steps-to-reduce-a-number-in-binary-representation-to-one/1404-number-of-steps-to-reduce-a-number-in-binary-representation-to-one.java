class Solution {
    public int numSteps(String s) {
        StringBuilder str = new StringBuilder(s);

        int cnt = 0;
        while (str.length() > 1) {
            int n = str.length();

            if (str.charAt(n - 1) == '0') divide(str);
            else addToString(str);

            cnt++;
        }

        return cnt;
    }

    private void divide (StringBuilder s) {
        s.deleteCharAt(s.length() - 1);
        return;
    }

    private void addToString (StringBuilder s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) != '0') {
            s.setCharAt(i, '0');
            i--;
        }
        if (i < 0) {
            s.insert(0, '1');
        } else {
            s.setCharAt(i, '1');
        }

        return;
    }
}