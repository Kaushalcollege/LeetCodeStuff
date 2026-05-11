class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0, r = n - 1;
        int[] res = new int[2];

        // Since Input array is sorted, use two-pointers approach.

        while (l < r) {
            int sum = numbers[l] + numbers[r];
            // System.out.println(sum);

            if (sum < target) l++;
            else if (sum > target) r--;
            else {
                res[0] = l + 1;
                res[1] = r + 1;
                break;
            }
        }

        return res;
    }
}