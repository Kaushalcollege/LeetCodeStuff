class Solution {
    public int strStr(String haystack, String needle) {
        /*
            -- I have 2 strings -- haystack and needle.
            -- My objective is to find out the first occurence of the needle string within the haystack string.
            -- now needle string can occur many times within the haystack string, but the index of the first occurence is needed.
            -- From the examples we can deduce that the index of the start of the needle string is the index of the entire string.
            -- But if i just need to find the first occurence of a character within the haystack string i can just use haystack.indexOf(character);
            -- so i will check each and every possible substring.
        */

        for (int i = 0; i < haystack.length(); i++){
            for (int j = i; j < haystack.length(); j++){
                String s = haystack.substring(i, j + 1);
                if (s.equals(needle)) return i;
            }
        }
        return -1;
    }
}