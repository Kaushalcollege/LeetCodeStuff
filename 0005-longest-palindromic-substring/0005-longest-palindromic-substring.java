class Solution {
    public String longestPalindrome(String s) {
        /*
            -- Brute force is to generate all the possible substrings and then find the longest.
            -- What is the optimal solution then?
        */

    //     int n = s.length();
    //     String longest = "";

    //     for (int i = 0; i < n; i++){
    //         for (int j = i; j < n; j++){
    //             String subbu = s.substring(i, j + 1);
    //             if (pal(subbu) & subbu.length() > longest.length()) longest = subbu;
    //         }
    //     }
    //     return longest;
    // }

    // private boolean pal (String s){
    //     int l = 0, r = s.length() - 1;
    //     while (l <= r){
    //         if (s.charAt(l) != s.charAt(r)) return false;
    //         l++;
    //         r--;
    //     }
    //     return true;
    // }

    int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len <= 2) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];
                }
                if (dp[i][j] && len > ans.length()) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
        
    }
}