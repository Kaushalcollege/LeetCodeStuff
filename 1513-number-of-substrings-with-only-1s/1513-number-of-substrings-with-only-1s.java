class Solution {
    public int numSub(String s) {
        long mod = 1000000007;
        long ans = 0, count = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            } else {
                ans += count * (count + 1) / 2;
                count = 0;
            }
        }

        ans += count * (count + 1) / 2;
        return (int)(ans % mod);
    }
}
