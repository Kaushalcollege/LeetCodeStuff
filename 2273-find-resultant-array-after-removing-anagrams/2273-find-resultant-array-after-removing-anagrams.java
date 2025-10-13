class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        for (String s : words) res.add(s);
        boolean del = true;

        while (del){
            del = false;
            for (int i = 1; i < res.size(); i++){
                if (isAnagram(res.get(i - 1), res.get(i))){
                    res.remove(i);
                    del = true;
                }
            }
        }
        return res;
    }

    private boolean isAnagram(String s1, String s2){
               if (s1.length() != s2.length()) return false;
        
        // for lowercase a-z
        int[] freq = new int[26];  

        // Count frequency of each character in s1
        for (int i = 0; i < s1.length(); i++)
            freq[s1.charAt(i) - 'a']++;

        // Subtract frequency using characters from s2
        for (int i = 0; i < s2.length(); i++)
            freq[s2.charAt(i) - 'a']--;

        // Check if all frequencies are zero
        for (int count : freq) {
            if (count != 0)
                return false;
        }

        return true;
    }
}