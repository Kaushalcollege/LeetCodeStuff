class Solution {
    ArrayList<String> res = new ArrayList<>();
    public String getHappyString(int n, int k) {
        char[] chars = {'a','b','c'};
        f (n, new StringBuilder(), chars);
        Collections.sort(res);
        if (k > res.size()) return "";
        return res.get(k - 1);
    }

    private void f (int n, StringBuilder sb, char[] chars) {
        if (sb.length() == n) {
            res.add(sb.toString());
            return;
        }

        for (char c : chars) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) continue;

            sb.append(c);
            f(n, sb, chars);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}