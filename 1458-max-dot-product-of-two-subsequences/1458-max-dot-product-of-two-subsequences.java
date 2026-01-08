class Solution {
    int[] A, B;
    int N, M;
    Integer[][] memo;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        // We use a pick and notPick method :::
        /*
            -- Let us assume that f (x, y) returns the max dot product till idx i in nums1 and idx j in nums2
            -- We can either choose to add nums[x] * nums[y] or skip nums[x] and add nums[x + 1] * nums2[y] or either skip both and add nums[x] * nums[y + 1]
        */

        A = nums1; B = nums2;
        N = A.length; M = B.length;
        memo = new Integer[N][M];
        return f (0, 0);
    }

    private int f (int x, int y) {
        if (x == N || y == M)
            return Integer.MIN_VALUE / 2;
        
        if(memo[x][y] != null) return memo[x][y];

        int pick = A[x] * B[y] + Math.max(0, f(x + 1, y + 1));
        int skip1 = f(x + 1, y);
        int skip2 = f(x, y + 1);

        memo[x][y] = Math.max(pick, Math.max(skip1, skip2));
        return memo[x][y];
    }
}