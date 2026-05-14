class Solution {
    public boolean isGood(int[] nums) {

        int n = 0;

        // find max element
        for (int num : nums) n = Math.max(n, num);
        
        // size check
        if (nums.length != n + 1) return false;

        int[] freq = new int[201];

        for (int num : nums) freq[num]++;

        for (int x = 1; x < n; x++) if (freq[x] != 1) return false;
        return freq[n] == 2;
    }
}