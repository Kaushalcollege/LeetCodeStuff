class Solution {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> solution = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] considered = new boolean[nums.length];
        System.out.println(Arrays.toString(considered));
        f (nums, 0, considered);
        return solution;
    }

    private void f (int[] arr, int idx, boolean[] considered) {
        if (idx >= arr.length) {
            solution.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (considered[i]) continue;

            temp.add(arr[i]);
            considered[i] = true;
            f (arr, idx + 1, considered);
            // temp.remove(temp.size() - 1);
            // temp.removeAll(temp);
            considered[i] = false;
            // f (arr, idx, considered);
            temp.removeLast();
        }
    }
}