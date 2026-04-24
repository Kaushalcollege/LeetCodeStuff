class Solution {
    public int[] shortestToChar(String s, char c) {
        List<Integer> list = new ArrayList<>();
        int len = s.length();

        for (int x = 0; x < s.length(); x++) if (s.charAt(x) == c) list.add(x);

        int[] res = new int[len];
        int idx = -1;
        for (int x = 0; x < len; x++) {
            idx = binClosest(list, x);
            res[x] = Math.abs(idx - x);
        }

        return res;
    }

    private int binClosest (List<Integer> list, int t) {
        int n = list.size();
        int i;

        for (i = 1; i < n; i++) {
            if (list.get(i) >= t) break;
        }

        if (i == n) {
            return list.get(n - 1);
        }
      
        // Check the current and previous element for closest
        if ((list.get(i) - t) <= t - list.get(i - 1))
            return list.get(i);
        else
            return list.get(i - 1);
    }
}