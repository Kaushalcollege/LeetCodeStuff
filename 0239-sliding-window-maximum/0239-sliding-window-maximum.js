/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var maxSlidingWindow = function(nums, k) {
    /*
        -- Very General sliding window application.
        -- Start from left ptr = 0 and right ptr = k - 1.
        -- We have to add the max element of all the sub arrays into List.
        -- We have to use deque.
    */

    if (nums.length === 1) return [nums[0]];

    const n = nums.length;
    const res = [];
    const dq = []; // will store indices
    let idx = 0;

    for (let i = 0; i < n; i++) {
        // Remove indices that are out of this window
        while (dq.length && dq[0] <= i - k) {
            dq.shift();
        }

        // Remove elements smaller than current (not useful)
        while (dq.length && nums[dq[dq.length - 1]] <= nums[i]) {
            dq.pop();
        }

        dq.push(i);

        // Add to result once we reach size k
        if (i >= k - 1) {
            res.push(nums[dq[0]]);
        }
    }

    return res;
};