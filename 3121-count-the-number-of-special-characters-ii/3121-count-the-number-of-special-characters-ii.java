class Solution {
    public int numberOfSpecialChars(String word) {
        int[] freq = new int[256];
        Arrays.fill(freq, -1);

        // for (char c : word.toCharArray()) freq[c - 'a']
        for (int x = 0; x < word.length(); x++) {
            if (Character.isUpperCase(word.charAt(x)) && freq[(int)word.charAt(x)] == -1) freq[(int)word.charAt(x)] = x;
            else if (Character.isLowerCase(word.charAt(x))) freq[(int)word.charAt(x)] = x;
        }
        int count = 0;

        for (int x = 65; x < 91; x++) {
            if (freq[x] != -1 && freq[x + 32] != -1) {
                if (freq[x] > freq[x + 32]) {
                    System.out.println(x);
                    System.out.println(x + 32);
                    count++;
                }
            }
        }


        return count;
    }
}