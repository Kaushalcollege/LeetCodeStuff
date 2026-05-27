class Solution {
    public int numberOfSpecialChars(String word) {
        Map<Character, Boolean> map = new HashMap<>();

        for (char c : word.toCharArray()) map.put(c, true);
        int c = 0;
        for (int x = 65; x < 91; x++) {
            if (map.containsKey((char)x) && map.containsKey((char)(x + 32))) c++;
            
        }


        return c;
    }
}