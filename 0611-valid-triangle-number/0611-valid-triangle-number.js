/**
 * @param {number[]} nums
 * @return {number}
 */
var triangleNumber = function(nums) {
    var a = nums.sort((a, b) => a - b);

    let count = 0;

        for (let k = nums.length - 1; k >= 2; k--){ // Original k - loop
            let i = 0, j = k - 1;

            while (j > i){ // 2 - pointer loop.
                if ((nums[i] + nums[j]) > nums[k]){
                    count += (j - i); // bulk count
                    j--;              // move j down
                }
                
                else {
                    i++;              // move i up
                }
            }
        }
        return count;
};