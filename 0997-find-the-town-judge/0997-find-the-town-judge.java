class Solution {
    public int findJudge(int n, int[][] trust) {
        // Score array: +1 for being trusted, -1 for trusting someone
        int[] score = new int[n + 1];

        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];
            score[a]--;  // a trusts somebody -> decrease
            score[b]++;  // b is trusted by a -> increase
        }

        // Check for judge: someone with score == n-1
        for (int i = 1; i <= n; i++) {
            if (score[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
