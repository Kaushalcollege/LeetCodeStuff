class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int min = n + 1;

        for (int x = 0; x < n; x++) {
            int ele = nums[x];

            if (map.containsKey(ele)) min = Math.min(min, x - map.get(ele));
            map.put(rev(ele), x);
        }

        return min == n + 1 ? -1 : min;
    }
    private int rev (int x) {
        // Digit Reverse.
        int rev = 0;
        int rem = 0;
        while (x > 0) {
            rem = x % 10;
            rev = rev * 10 + rem;
            x /= 10;
        }

        return rev;
    }
}