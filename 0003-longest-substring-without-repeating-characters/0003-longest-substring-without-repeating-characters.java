class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
                longest = Math.max(longest, set.size());
            }
            else {
                set.clear();
                set.add(c);
            }
        }
        return longest;
    }
}