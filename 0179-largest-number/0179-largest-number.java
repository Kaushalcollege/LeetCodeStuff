class Solution {
    public String largestNumber(int[] nums) {
        String[] new_nums = new String[nums.length];

        for (int i = 0; i < nums.length; i++) new_nums[i] = String.valueOf(nums[i]);
        // Arrays.sort(new_nums);
        Arrays.sort(new_nums, (a, b) -> (b + a).compareTo(a + b));

        if (new_nums[0].equals("0")) return "0";
        // System.out.println(Arrays.toString(new_nums));
        String res = "";

        for (String i : new_nums) res += i;

        return res;
        /*
            7, 8, 56, 90, 23, 45
            9087564523
        */
    }
}