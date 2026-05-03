class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        char[] c = s.toCharArray();
        int n = s.length();

        for (int x = 0; x < n; x++) {
            char firstChar = c[0];
            for (int y = 0; y < n - 1; y++) c[y] = c[y + 1];
            c[n - 1] = firstChar;
            // System.out.println(Arrays.toString(c));

            if (String.valueOf(c).equals(goal)) return true;
        }

        return false;
    }
}