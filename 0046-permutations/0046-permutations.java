class Solution {
    public List<List<Integer>> permute(int[] nums) {
        /*
            -- Pattern Recognition:
            -- The constraints are small as well as the Output format is a list of lists -- screams BackTracking.
        */

        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];

        backtrackHelper(nums, new ArrayList<>(), vis, res);

        return res;
    }

    public void backtrackHelper(int[] nums, List<Integer> path, boolean[] v, List<List<Integer>> res){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return; // Backtrack.
        }

        for (int i = 0; i < nums.length; i++){
            if (v[i]) continue;

            //choose the number:
            v[i] = true;
            path.add(nums[i]);

            // Recurse:
            backtrackHelper(nums, path, v, res);

            // Unchoose or backtrack -- remove the number.
            path.remove(path.size() - 1);
            v[i] = false;
        }
    }
}