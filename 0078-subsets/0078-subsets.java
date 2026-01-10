class Solution {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> solution = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        // for (int i = 0; i < nums.length; i++) backTrack (nums, i);
        backTrack (nums, 0);
        return solution;
    }

    private void backTrack (int[] nums, int idx) {
        if (idx >= nums.length) {
            solution.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[idx]);
        backTrack (nums, idx + 1);
        temp.remove(temp.size() - 1);
        backTrack (nums, idx + 1);
    }
}