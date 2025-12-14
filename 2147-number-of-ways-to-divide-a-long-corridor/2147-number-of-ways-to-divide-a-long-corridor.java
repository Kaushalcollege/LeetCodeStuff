class Solution {
    public int numberOfWays(String corridor) {
        int MOD = 1000000007;
        int seatCount = 0;
        for (char c : corridor.toCharArray()) if (c == 'S') seatCount++;
        if (seatCount == 0 || seatCount % 2 != 0) return 0;
        Map<Integer, Integer> segments = new LinkedHashMap<>();
        int start = -1;

        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                if (start == -1) {
                    start = i;
                } else {
                    segments.put(start, i);
                    start = -1;
                }
            }
        }

        System.out.println(segments);

        int endOfFirst = -1;
        long prod = 1; // use long

        for (Map.Entry<Integer, Integer> entry : segments.entrySet()) {
            if (endOfFirst == -1) {
                endOfFirst = entry.getValue();
                continue;
            }

            int startOfSecond = entry.getKey();
            prod = (prod * (startOfSecond - endOfFirst)) % MOD;
            endOfFirst = entry.getValue(); 
        }

        return (int)prod; 
    }
}

