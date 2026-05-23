class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        // boolean matched = true;

        for (int x = 0; x < n; x++) {
            boolean matched = true;
            for (int y = 0; y < n; y++) {
                if (nums[(y + x) % n] != sorted[y]) {
                    matched = false;
                    break;
                }
            }
            if (matched) return true;
        }

        return false;
    }
}