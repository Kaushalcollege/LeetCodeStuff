class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int n = nums.length;
        Set<Integer> ii = new HashSet<>();
        int sum = 0;
        for (int i : nums) {
            if (!ii.contains(i)) {
                ii.add(i);
                sum += i;
            }
            else {
                res[0] = i;
            }
        }

        res[1] = (n * (n + 1) / 2) - sum;

        return res;
    }
}