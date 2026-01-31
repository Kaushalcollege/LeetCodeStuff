class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char min = '{';
        for (char c : letters) {
            if (c - 'a' > target - 'a') min = (c - 'a' < min - 'a') ? c : min;
        }
        return min == '{' ? letters[0] : min;
    }
}