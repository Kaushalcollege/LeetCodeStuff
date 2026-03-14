class Solution {
    ArrayList<String> res = new ArrayList<>();
    public String getHappyString(int n, int k) {
        f (n, new StringBuilder(), 0);
        Collections.sort(res);
        if (k > res.size()) return "";
        return res.get(k - 1);
    }

    private void f (int n, StringBuilder sb, int idx) {
        if (sb.length() == n) {
            String s = sb.toString();
            if (isHappy(s)) res.add(s);
            return;
        }
        sb.append('a');
        f (n, sb, idx + 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append('b');
        f (n, sb, idx + 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append('c');
        f (n, sb, idx + 1);
        sb.deleteCharAt(sb.length() - 1);

        return;
    }

    private boolean isHappy (String s) {
        for (int i = 1; i < s.length(); i++) if (s.charAt(i) == s.charAt(i - 1)) return false;

        return true;
    }
}