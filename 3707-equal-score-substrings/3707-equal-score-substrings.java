class Solution {
    public boolean scoreBalance(String s) {
        int total = 0;
        for (char c : s.toCharArray()) total += c - 'a' + 1;
        int sum = 0;
        for (char c : s.toCharArray()){
            sum += c - 'a';
            if (total == 2 * sum) return true;
        }
        return false;
    }
}