class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int mark = -1;
        int marknxt = -1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1 && mark == -1){
                mark = i;
                continue;
            }
            if (mark != -1 && nums[i] == 1) marknxt = i;
            System.out.println(mark + " " + marknxt);
            if (mark != -1 && marknxt != -1){
                if (Math.abs(mark - marknxt) - 1 < k) return false;
                mark = marknxt;
                marknxt = -1;
            }
        }
        return true;
    }
}