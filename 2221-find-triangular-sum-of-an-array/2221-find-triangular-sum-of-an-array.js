/**
 * @param {number[]} nums
 * @return {number}
 */
var triangularSum = function(nums) {
    if (nums.length == 1) return nums[0];

    let n = nums.length;

    while (n > 1){
            for (let i = 0; i < n - 1; i++){
                nums[i] = (nums[i] + nums[i+1]) % 10;
            }
            n--;
        }

        return nums[0];
};