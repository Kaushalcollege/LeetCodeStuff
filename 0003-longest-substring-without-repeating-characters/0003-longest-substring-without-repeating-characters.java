class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), longest = 0;

        for (int x = 0; x < n; x++) {
            int[] hash = new int[256];
            for (int y = x; y < n; y++) {
                if (hash[(int)s.charAt(y)] == 1) break;
                longest = Math.max(y - x + 1, longest);
                hash[(int)s.charAt(y)] = 1;
            }
        }


        return longest;
    }
}