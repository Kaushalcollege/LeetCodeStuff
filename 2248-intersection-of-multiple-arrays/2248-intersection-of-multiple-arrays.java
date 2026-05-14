class Solution {
    public List<Integer> intersection(int[][] nums) {
        int[] count = new int[1001];
        List<Integer> res = new ArrayList<>();
         
        for (int[] num : nums) for (int x : num) count[x]++;

        for (int x = 0; x < count.length; x++) if (count[x] == nums.length) res.add(x);

        return res;
    }
}