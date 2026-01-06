class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare (int[] a, int[] b) {return a[0] - b[0];}
        });


        int l = 0, r = nums.length - 1;
        // int sum = 0;

        while (l <= r) {
            int sum = arr[l][0] + arr[r][0];

            if (sum == target) return new int[] {arr[l][1], arr[r][1]};
            else if (sum > target) r--;
            else if (sum < target) l++;
        }
        return new int[]{-1, -1};
    }
}