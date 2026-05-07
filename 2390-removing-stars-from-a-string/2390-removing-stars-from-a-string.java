class Solution {
    public String removeStars(String s) {
        char[] c = s.toCharArray();
        int n = s.length(), top = 0;

        for (int x = 0; x < n; x++) {
            if (c[x] == '*') top--;
            else c[top++] = c[x];
        }

        return new String(c, 0, top);
    }
}