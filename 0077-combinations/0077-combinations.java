class Solution {
    public List<List<Integer>> combine(int n, int k) {
        /*
            -- The constraints are less and the output type is list of lists -- Backtracking.
        */

        boolean[] v = new boolean[n + 1];
        v[0] = true;

        List<List<Integer>> res = new ArrayList<>();

        btHelper(n, k, v, res, new ArrayList<>(), 1);

        return res;
    }

    public void btHelper (int n, int k, boolean[] v, List<List<Integer>> res, List<Integer> combination, int curr){

        //base case:
        if (combination.size() == k){
            res.add(new ArrayList<>(combination));
            return; // BackTrack.
        }

        for (int i = curr; i <= n; i++){
            if (v[i]) continue;

            v[i] = true;
            combination.add(i);

            // Recurse:
            btHelper(n, k, v, res, combination, i + 1);

            combination.remove(combination.size() - 1);
            v[i] = false;
        }
    }
}