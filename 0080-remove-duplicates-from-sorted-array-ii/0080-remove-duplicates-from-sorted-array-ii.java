class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        HashMap<Integer, Integer> hello = new HashMap<>();
        for (int i : nums){
            hello.put(i, hello.getOrDefault(i, 0) + 1);
        }
        System.out.println(hello);
        for (int i : hello.keySet()) if (hello.get(i) > 2) hello.put(i, 2);
        System.out.println(hello);
        int sum = 0;
        int idx = 0;
        for (int i : hello.keySet()){
            int val = hello.get(i);
            sum += val;
            while(val-- > 0){
                nums[idx++] = i;
            }
        }
        Arrays.sort(nums, 0, sum);
        System.out.println(Arrays.toString(nums));
        return sum;
    }
}