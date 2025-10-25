class Solution {
    public int totalMoney(int n) {
        // This is O(n) time complexity.
        // int sum = 1;
        // for (int i = 2; i <= n; i++){
        //     if (i % 7 == 0) sum += 7 + (i / 7 - 1);
        //     else sum += (i % 7) + (i / 7);
        // }
        // return sum;

        //O(1) solution

        /*
            1 + 2 + 3 + 4 + 5 + 6 + 7 == 28 + (7 * 0)
            2 + 3 + 4 + 5 + 6 + 7 + 8 == 28 + (7 + 1)

            total = 28 * (number of weeks) + 7 * (0 + 1 + 2 + 3 + ... + (number of weeks)).
        */

        int weeks = n / 7;
        int days = n % 7;

        // Sum for complete weeks
        int total = 28 * weeks + (7 * weeks * (weeks - 1)) / 2;

        // Sum for remaining days in the last incomplete week
        total += days * weeks + (days * (days + 1)) / 2;

        return total;
    }
}