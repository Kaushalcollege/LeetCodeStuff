class Solution {
    public boolean hasSameDigits(String s) {
        while (s.length() > 2){
            char[] str = s.toCharArray();
            StringBuilder ii = new StringBuilder();
            for (int i = 0; i < str.length - 1; i++){
                int hello = ((str[i] - '0') + (str[i + 1] - '0')) % 10;
                ii.append(hello);
            }
            s = ii.toString();
        }
        return s.charAt(0) == s.charAt(1);
    }
}