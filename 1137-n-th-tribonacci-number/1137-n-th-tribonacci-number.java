class Solution {
    static Map<Integer, Integer> cache = new HashMap<>();
    
    static {
        cache.put(0, 0);
        cache.put(1, 1);
        cache.put(2, 1);
    }

    public static int tribonacci(int n) {
        if (cache.containsKey(n)) return cache.get(n);
        
        cache.put(n, tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3));
        return cache.get(n);
    }
}