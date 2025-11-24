class Solution {
    public int averageValue(int[] nums) {
        int count = 0, sum = 0;
        for (int i : nums){
            if (i % 3 == 0 && i % 2 == 0){
                sum += i;
                count++;
            }
        }
        if (count == 0) return 0;
        return (int) (sum / count);
    }
}