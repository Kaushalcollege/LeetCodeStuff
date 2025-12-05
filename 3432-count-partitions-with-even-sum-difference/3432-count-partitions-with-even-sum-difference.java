// class Solution {
//     public int countPartitions(int[] nums) {
//         int total = 0, count = 0;
//         for (int i : nums) total += i;
//         for (int i = 0; i < nums.length; i++){
//             int l = i, r = i + 1, lsum = 0, rsum = 0;
//             while (l > -1 && r < nums.length){
//                 if (l > -1) lsum += nums[l--];
//                 else if (r < nums.length) rsum += nums[r++];
//             }
//             if (Math.abs(lsum - rsum) % 2 == 0) count++;
//         }
//         return count;
//     }
// }
class Solution {
    public int countPartitions(int[] nums) {
        int total = 0;
        for (int x : nums) total += x;

        if (total % 2 != 0) return 0;  // odd total => no valid partitions

        return nums.length - 1;        // all splits work
    }
}
