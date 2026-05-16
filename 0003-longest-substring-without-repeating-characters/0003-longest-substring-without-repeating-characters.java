class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), longest = 0;
        int[] hash = new int[256];
        int l = 0, r = 0;
        for (int x = 0; x < 256; x++) hash[x] = -1;

        while (r < n) {
            if (hash[(int)s.charAt(r)] != -1) if (hash[(int)s.charAt(r)] >= l) l = hash[(int)s.charAt(r)] + 1;

            longest = Math.max(longest, r - l + 1);
            hash[(int)s.charAt(r)] = r;
            r++;
        }

        return longest;
    }
}