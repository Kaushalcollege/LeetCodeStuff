class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int[] count = new int[divisors.length];

        int globalMax = 0;
        for (int i = 0; i < divisors.length; i++){
            for (int j : nums) if (j % divisors[i] == 0) count[i]++;
            // if (count[globalMax] > count[i]) globalMax = i;
            if (count[i] > count[globalMax] || 
               (count[i] == count[globalMax] && divisors[i] < divisors[globalMax])){
                globalMax = i;
            }
        }

        return divisors[globalMax];
    }
}