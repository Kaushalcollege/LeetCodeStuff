class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            int rem = 0;
            List<Integer> interim = new ArrayList<>();
            while (x > 0) {
                rem = x % 10;
                x /= 10;
                interim.add(rem);
            }
            Collections.reverse(interim);
            list.addAll(interim);
        }

        int[] res = new int[list.size()];
        int idx = 0;
        for (int x : list) res[idx++] = x;

        return res;
    }
}