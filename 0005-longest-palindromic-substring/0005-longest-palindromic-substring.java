class Solution {
    public String longestPalindrome(String s) {
        /*
            -- Brute force is to generate all the possible substrings and then find the longest.
        */

        int n = s.length();
        String longest = "";

        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                String subbu = s.substring(i, j + 1);
                if (pal(subbu) & subbu.length() > longest.length()) longest = subbu;
            }
        }
        return longest;
    }

    private boolean pal (String s){
        int l = 0, r = s.length() - 1;
        while (l <= r){
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}