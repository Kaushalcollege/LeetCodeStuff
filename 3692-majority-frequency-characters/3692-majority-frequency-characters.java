class Solution {
    public String majorityFrequencyGroup(String s) {
        /*
            -- What is this problem about?
            -- We are given a string s, where certain characters are repeated for certain number of times.
            -- What is frequency group?
            -- The frequency group for a value 'k' is the set of characters that appear exactly 'k' times in s.
            -- let us assume s = "aabbccc"
                    -- k == 2, group = {a, b}, n(group) = 2.
                    -- k == 1, group = {c}, n(group) = 1.

            -- My approach will be pretty basic -- initialize a frequency map
            -- and since the max length of s is 100, We can use List array.
        */

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);

        Map<Integer, List<Character>> table = new HashMap<>();

        for (Map.Entry<Character, Integer> row : freq.entrySet()){
            int i = row.getValue();
            table.putIfAbsent(i, new ArrayList<>());
            table.get(i).add(row.getKey());
        }

        int bestSize = 0;
        int bestFreq = 0;
        List<Character> bestGroup = new ArrayList<>();

        for (Map.Entry<Integer, List<Character>> row : table.entrySet()) {
            int freqVal = row.getKey();
            int size = row.getValue().size();

            if (size > bestSize || (size == bestSize && freqVal > bestFreq)) {
                bestSize = size;
                bestFreq = freqVal;
                bestGroup = row.getValue();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : bestGroup) sb.append(c);
        return sb.toString();
    }
}