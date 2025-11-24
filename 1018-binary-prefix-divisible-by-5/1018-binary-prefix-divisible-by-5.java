class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int num = 0;
        for (int i : nums){
            // num = (num * 2) + i;
            // if (num % 5 == 0) res.add(true);
            // else res.add(false);
            num = (num * 2 + i) % 5;  // keep only remainder
            res.add(num == 0);
        }
        return res;
    }
}