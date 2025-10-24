class Solution {
    public int nextBeautifulNumber(int n) {
        if (n < 0) return 0;
        while (true) {
            n += 1;
            if (is_beautiful(n)) return n;
        }
    }

    private boolean is_beautiful(int x){
        Map<Integer, Integer> res = new HashMap<>();
        int rem = 0;
        while(x > 0) {
            rem = x % 10;
            res.put(rem, res.getOrDefault(rem, 0) + 1);
            x /= 10;
        }
        for (int i : res.keySet()) if (i != res.get(i)) return false;

        return true;
    }
}