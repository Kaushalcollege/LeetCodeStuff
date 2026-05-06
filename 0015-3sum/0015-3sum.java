class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //O(n^2)
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int x = 0; x < n; x++) {
            Set<Integer> store = new HashSet<>();
            for (int y = x + 1; y < n; y++) {
                int z = -(nums[x] + nums[y]);
                if (store.contains(z)) {
                    List<Integer> temp = new ArrayList<>();
                    Collections.addAll(temp, nums[x], nums[y], z);
                    Collections.sort(temp);
                    set.add(temp);
                }
                store.add(nums[y]);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> l : set) res.add(l);

        return res;
    }
}