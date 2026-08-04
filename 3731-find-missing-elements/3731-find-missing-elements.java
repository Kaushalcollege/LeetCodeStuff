class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int s = nums[0], e = nums[n - 1];
        Set<Integer> st = new HashSet<>();
        for (int x : nums) st.add(x);
        System.out.println(st);
        for (int x = s; x <= e; x++) {
            if (!st.contains(x)) res.add(x);
        }
        return res;
    }
}