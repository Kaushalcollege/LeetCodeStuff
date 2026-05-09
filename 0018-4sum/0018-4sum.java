class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int x = 0; x < n; x++) {
            for (int y = x + 1; y < n; y++) {
                Set<Long> store = new HashSet<>();

                for (int z = y + 1; z < n; z++) {
                     long t = (long) target
                            - (long) nums[x]
                            - (long) nums[y]
                            - (long) nums[z];
                    // System.out.println(t);
                    if (store.contains(t)) {
                        List<Integer> temp = new ArrayList<>();
                        Collections.addAll(temp, nums[x], nums[y], nums[z], (int) t);
                        Collections.sort(temp);
                        set.add(temp);
                    }

                    store.add((long) nums[z]);
                }
            }
        }

        res.addAll(set);
        return res;
    }
}