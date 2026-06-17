class Solution {
    public char processStr(String s, long k) {
        long length = 0;
        // First construct the length of the string :
        for (char c : s.toCharArray()) {
            switch(c) {
                case '*' :
                    if (length > 0) length--;
                    break;
                case '#' :
                    length *= 2;
                    break;
                case '%' :
                    break;
                default :
                    length++;
                    break;
            }
        }

        if (k + 1 > length) return '.';

        for (int x = s.length() - 1; x >= 0; x--) {
            char c = s.charAt(x);

            switch(c) {
                case '*' :
                    length++;
                    break;
                case '#' :
                    if (k + 1 > (length + 1) / 2) k -= length / 2;
                    length = (length + 1) / 2;
                    break;
                case '%' :
                    k = length - k - 1;
                    break;
                default :
                    if (k + 1 == length) return c;
                    length--;
                    break;
            }
        }
        return '.';
    }
}