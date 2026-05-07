class Solution {
    public String removeStars(String s) {
        Stack<Character> stk = new Stack<>();
        int len = s.length();
        StringBuilder sb = new StringBuilder();

        for (int x = 0; x < len; x++) {
            char c = s.charAt(x);

            if (stk.isEmpty() && c != '*') stk.push(c);
            else if (c == '*') stk.pop();
            else stk.push(c);
        }

        while (!stk.isEmpty()) sb.append(stk.pop());

        return sb.reverse().toString();
    }
}