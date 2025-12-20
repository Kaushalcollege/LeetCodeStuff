class Solution {
    public int minDeletionSize(String[] strs) {
        int len = strs[0].length();

        int count = 0;
        for (int i = 0; i < len; i++) {
            StringBuilder res = new StringBuilder();
            for (String s : strs) {
                res.append(s.charAt(i));
            }
            char[] str = res.toString().toCharArray();
            Arrays.sort(str);
            String string = new String(str);
            if (!res.toString().equals(string)) count++;
        }
        return count;
    }
}