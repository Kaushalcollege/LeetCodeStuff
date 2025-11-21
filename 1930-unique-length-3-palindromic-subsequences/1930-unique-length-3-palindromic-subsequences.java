class Solution {
    public int countPalindromicSubsequence(String s) {
        // int r = s.length() - 1;
        // int m = 0;
        // Set<String> set = new HashSet<>();
        // int l = 0;

        // while (l < s.length() - 2){
        //     while(s.charAt(l) != s.charAt(r)) r--;
        //     m = l + 1;
        //     while(m < r){
        //         String sub = "" + s.charAt(l) + s.charAt(m) + s.charAt(r);
        //         if (!set.contains(sub)) set.add(sub);
        //         m++;
        //     }
        //     l++;
        //     r = s.length() - 1;
        // }
        // return set.size();


        Map<Character, List<Integer>> ii = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            ii.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(i);
        }

        Set<String> set = new HashSet<>();
        for (Map.Entry<Character, List<Integer>> entry : ii.entrySet()){
            int n = entry.getValue().size();
            if (n == 1) continue;

            int l = entry.getValue().get(0);
            int r = entry.getValue().get(n - 1), m = l + 1;

            while(m < r){
                String sub = "" + s.charAt(l) + s.charAt(m) + s.charAt(r);
                if (!set.contains(sub)) set.add(sub);
                m++;
            }
        }
        return set.size();
    }
}