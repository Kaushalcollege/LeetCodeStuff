class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> ii = new HashSet<>();
        int[] res = new int[2];
        int idx = 0;
        for (int i : nums){
            if (idx > 1) break;
            if (ii.contains(i)) res[idx++] = i;
            else ii.add(i);
        }
        return res;
    }
}