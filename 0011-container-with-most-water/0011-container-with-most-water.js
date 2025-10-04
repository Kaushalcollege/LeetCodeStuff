/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    let ma = 0;
    let l = 0, r = height.length - 1;
    while (l < r) {
        let ca = Math.min(height[l], height[r]) * (r - l);
        ma = Math.max(ma, ca);
        if (height[l] < height[r]) {
            l++;
        } else {
            r--;
        }
    }
    return ma;
};
