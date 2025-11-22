class Solution {
    public int minimumOperations(int[] nums) {
        int oper = 0;
        for (int i : nums) {
            if (i % 3 == 1 || i % 3 == 2) oper++;
        }
        return oper;
    }
}