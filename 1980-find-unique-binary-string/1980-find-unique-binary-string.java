class Solution {
    List<String> All = new ArrayList<>();
    public String findDifferentBinaryString(String[] nums) {
        backTrack (nums[0].length(), 0,  new StringBuilder());
        // System.out.println(All);
        Set<String> set = new HashSet<>(Arrays.asList(nums));

        for (String s : All) {
            if (!set.contains(s)) return s;
        }
        return "";
    }

    private void backTrack (int n, int idx, StringBuilder s) {

        if (s.length() == n) {
            All.add(s.toString());
            return;
        }
        s.append('0');
        backTrack(n, idx + 1, s);
        s.deleteCharAt(s.length() - 1);
        s.append('1');
        backTrack(n, idx + 1, s);
        s.deleteCharAt(s.length() - 1);
        return;
    }
}