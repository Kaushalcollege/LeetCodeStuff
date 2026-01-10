class Solution {
    StringBuilder res = new StringBuilder();
    List<String> sol = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        f (n, n, n);
        return sol;
    }

    private void f (int open, int close, int n) {
        if ((open == 0) && (close == 0) && (res.length() == 2 * n)) {
            sol.add(new String(res.toString()));
            return;
        }
        // if (open < 0 || close < 0) return;
        // System.out.println(open + " " + close);
        if (open > 0) {
            res.append('(');
            f (open - 1, close, n);
            res.setLength(res.length() - 1);
        }
        if (close > open) {
            res.append(')');
            f (open, close - 1, n);
            res.setLength(res.length() - 1);
        }
        return;
    }
}