class Solution {
    public int numberOfSpecialChars(String word) {
        // boolean[][] freq = new boolean[26][2];
        // int c = 0;

        // for (char x : word.toCharArray()) {
        //     if (x - 'a' > 0) freq[x - 'a'][0] = true;
        //     else freq[x - 'A'][1] = true;
        //     if (freq[x - 'a'][0] && freq[x - 'A'][1]) c++;
        // }


        // return c;

        Set<Character> set = new HashSet<>();
        int cnt = 0;

        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c) && !set.contains(Character.toUpperCase(c))) set.add(c);
            else if (!set.contains(c) && Character.isLowerCase(c) && set.contains(Character.toUpperCase(c))) {
                cnt++;
                // set.remove(Character.toUpperCase(c));
                // System.out.println("1");
            }
            else {
                 if (!set.contains(c) && set.contains(Character.toLowerCase(c))) {
                    cnt++;
                    set.add(c);
                    // System.out.println("2");
                    // set.remove(Character.toLowerCase(c));
                }
                // else if (set.isEmpty()) set.add(c);
                else set.add(c);
            }
        }

        return cnt;
    }
}