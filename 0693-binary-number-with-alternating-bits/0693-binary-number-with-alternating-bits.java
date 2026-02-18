class Solution {
    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);

        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (prev == curr) return false;
            prev = curr;
        }

        return true;
    }
}