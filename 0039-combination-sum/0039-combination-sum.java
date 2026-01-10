class Solution {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> sol = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        f (candidates, 0, target);
        return sol;
    }

    private void f (int[] a, int idx, int target) {
        if (target == 0) {
            sol.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0 || idx >= a.length) return;

        temp.add(a[idx]);
        f (a, idx, target - a[idx]);
        temp.remove(temp.size() - 1);
        f (a, idx + 1, target);
    }
}