class Solution {
    public String[] divideString(String s, int k, char fill) {

        if (s.length() % k == 0) {
            String[] res = new String[s.length() / k];
            int idx = 0, i = 0;
            while (i <= s.length() - k) {
                res[idx++] = s.substring(i, i + k);
                i += k;
            }
            return res;
        }

        String[] res = new String[s.length() / k + 1];
        int idx = 0, cnt = 0;

        for (int i = 0; i < s.length() / k; i++) {
            res[idx++] = s.substring(cnt, cnt + k);
            cnt += k;
        }

        String last = s.substring(cnt);
        while (last.length() < k) last += fill;
        res[idx] = last;

        return res;
    }
}
