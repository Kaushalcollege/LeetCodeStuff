class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for (int x = 0; x < n; x++) {
            if (x > 0 && nums[x] == nums[x - 1]) continue;

            int y = x + 1, z = n - 1;

            while (y < z) {
                int sum = nums[x] + nums[y] + nums[z];

                if (sum < 0) y++;

                else if (sum > 0) z--;

                else {
                    List<Integer> temp = new ArrayList<>();
                    Collections.addAll(temp, nums[x], nums[y], nums[z]);
                    res.add(temp);
                    y++;
                    z--;
                    while (y < z && nums[y] == nums[y - 1]) y++;
                    while (y < z && nums[z] == nums[z + 1]) z--;
                }
            }
        }

        return res;
    }
}