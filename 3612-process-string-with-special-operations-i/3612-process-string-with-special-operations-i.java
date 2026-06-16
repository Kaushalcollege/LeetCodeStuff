class Solution {
    public String processStr(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) res.append(c);
            else if (c == '#') res.append(res.toString());
            else if (c == '*' && res.length() > 0) res.setLength(res.length() - 1);
            else res.reverse();
        }

        return res.toString();
    }
}