class Solution {
    private static Map<Integer,Integer> memo = new HashMap<>();
    public int fib(int n) {
        if (memo.containsKey(n)) return memo.get(n);
        int res;

        if (n <= 1) res = n;

        else res = fib(n-1) + fib(n-2);

        memo.put(n, res);
        return res;
    }
}