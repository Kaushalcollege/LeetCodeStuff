class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[][] freq = new boolean[26][2];
        int c = 0;

        for (char x : word.toCharArray()) {
            // System.out.println(x - 'a');
            // System.out.println(x - 'a' + 32);
            if (x - 'a' >= 0) freq[x - 'a'][0] = true;
            else freq[x - 'a' + 32][1] = true;
            // if (freq[x - 'a'][0] && freq[x - 'a' + 32][1]) c++;
        }
        for (int x = 0; x < 26; x++) if (freq[x][0] && freq[x][1]) c++;


        // return c;

        // Set<Character> set = new HashSet<>();
        // int cnt = 0;

        // for (char c : word.toCharArray()) {
        //     if (Character.isLowerCase(c) && !set.contains(Character.toUpperCase(c))) set.add(c);
        //     else if (!set.contains(c) && Character.isLowerCase(c) && set.contains(Character.toUpperCase(c))) {
        //         cnt++;
        //         set.add(c);
        //         // set.remove(Character.toUpperCase(c));
        //         // System.out.println("1");
        //     }
        //     else {
        //          if (!set.contains(c) && set.contains(Character.toLowerCase(c))) {
        //             cnt++;
        //             set.add(c);
        //             // System.out.println("2");
        //             // set.remove(Character.toLowerCase(c));
        //         }
        //         // else if (set.isEmpty()) set.add(c);
        //         else set.add(c);
        //     }
        // }

        return c;
    }
}