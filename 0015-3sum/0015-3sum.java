class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++){
            Set<Integer> ii = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++){
                int thirdEle = -1 * (nums[i] + nums[j]);

                if (ii.contains(thirdEle)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(thirdEle);
                    Collections.sort(temp);
                    set.add(temp);
                }
                ii.add(nums[j]);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> i : set) res.add(i);

        return res;
    }
}