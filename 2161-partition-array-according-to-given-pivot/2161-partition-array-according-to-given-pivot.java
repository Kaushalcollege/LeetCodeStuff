class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> lesser = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        int c = 0, n = nums.length;

        for (int x : nums) {
            if (x < pivot) lesser.add(x);
            else if (x > pivot) greater.add(x);
            else c++;
        }
        int[] res = new int[n];
        int idx = 0;

        for (int x : lesser) res[idx++] = x;
        while(c-- > 0) res[idx++] = pivot;
        for (int x : greater) res[idx++] = x;

        return res;
    }
}