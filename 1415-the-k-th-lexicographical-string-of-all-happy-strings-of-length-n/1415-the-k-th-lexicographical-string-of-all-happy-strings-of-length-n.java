class Solution {
    Queue<String> res = new PriorityQueue<>();
    public String getHappyString(int n, int k) {
        char[] chars = {'a','b','c'};
        f (n, new StringBuilder(), chars);
        // Collections.sort(res);
        if (k > res.size()) return "";
        String element = "";
        for (int i = 0; i < k; i++) {
            element = res.poll();
        }
        return element;
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