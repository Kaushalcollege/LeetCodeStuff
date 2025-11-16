// class Solution {
//     public int numSub(String s) {
//         long mod = 1000000007;
//         long n = s.length();
//         long total = n * (n + 1) / 2;
//         long hasZero = 0;
//         for (int i = 0; i < s.length(); i++){ 
//             for (int j = i; j < s.length(); j++){ 
//                 String sub = s.substring(i, j + 1);
//                 if (sub.contains("0")) hasZero++;
//             } 
//         } 
//         long ans = (total - hasZero) % mod;
//         return (int)(ans < 0 ? ans + mod : ans);
//     }
// } -- TLE error.

// class Solution {
//     public int numSub(String s) {
//         long mod = 1000000007;
//         long n = s.length();

//         long total = n * (n + 1) / 2;  // all substrings
//         long hasZero = 0;              // count substrings that contain '0'

//         for (int i = 0; i < n; i++) {
//             boolean seenZero = false;

//             for (int j = i; j < n; j++) {
//                 if (s.charAt(j) == '0') seenZero = true;
//                 if (seenZero) hasZero++; // this substring contains '0'
//             }
//         }

//         return (int) ((total - hasZero) % mod);
//     }
// }


class Solution {
    public int numSub(String s) {
        long mod = 1000000007;
        long ans = 0;

        long run = 0;    // length of current run of 1s

        for (char c : s.toCharArray()) {
            if (c == '1') {
                run++;
            } else {
                ans += run * (run + 1) / 2;
                run = 0;
            }
        }

        ans += run * (run + 1) / 2; // last run

        return (int)(ans % mod);
    }
}

