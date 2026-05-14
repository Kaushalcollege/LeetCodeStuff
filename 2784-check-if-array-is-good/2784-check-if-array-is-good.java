class Solution {
    public boolean isGood(int[] nums) {
        int base = nums.length - 1;

        boolean[] seen = new boolean[base + 1];

        for (int x : nums) {
            if (x < base + 1 && !seen[x]) seen[x] = true;
            else if (x < base && seen[x]) return false;
            else if (seen[base] && x == base) seen[0] = true;
        }
        // seen[0] = true;
        System.out.println(Arrays.toString(seen));

        for (boolean x : seen) if (!x) return false;

        return true;
    }
}