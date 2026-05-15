class Solution {

    public int arrayPairSum(int[] nums) {

        int[] freq = new int[20001];

        // shift by +10000
        for (int num : nums) {
            freq[num + 10000]++;
        }

        int sum = 0;

        boolean take = true;

        for (int i = 0; i < 20001; i++) {

            while (freq[i] > 0) {

                if (take) {
                    sum += (i - 10000);
                }

                take = !take;

                freq[i]--;
            }
        }

        return sum;
    }
}