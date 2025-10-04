class Solution {
    public int maxArea(int[] height) {
        int ma = 0;
        int l = 0;            
        int r = height.length - 1; 
        while (l < r) {
            int ca = Math.min(height[l], height[r]) * (r - l);
            ma = Math.max(ma, ca);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        
        return ma; 
    }
}
