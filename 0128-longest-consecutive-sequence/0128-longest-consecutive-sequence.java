class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return n;
        int longest = 1;
        Set<Integer> unorderedSet = new HashSet<>();

        for (int x : nums) unorderedSet.add(x);

        for (int x : unorderedSet) {
            if (!unorderedSet.contains(x - 1)) {
                int cnt = 1;
                int y = x;
                while(unorderedSet.contains(y + 1)) {
                    y++;
                    cnt++;
                }
                if (cnt > longest) longest = cnt;
            }
        }

        return longest;
    }
}