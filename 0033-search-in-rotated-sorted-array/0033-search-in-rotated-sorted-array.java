class Solution {
    public int search(int[] nums, int target) {
        //Possibly left rotated.
        // unknown index k.
        // Brute Force.
        Map<Integer, Integer> ii = new HashMap<>();
        for (int i = 0; i < nums.length; i++) ii.put(nums[i], i);
        Arrays.sort(nums);
        return binSearch(ii, nums, target);
    }

    private int binSearch(Map<Integer, Integer> map, int[] a, int k){
        int i = 0, j = a.length - 1, m = 0;

        while(i <= j){
            m = i + (j - i) / 2;

            if (a[m] > k) j = m - 1;
            else if (a[m] < k) i = m + 1;
            else return map.get(a[m]);
        }
        return -1;
    }
}