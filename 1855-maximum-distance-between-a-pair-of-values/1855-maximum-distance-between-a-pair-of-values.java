class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max_dist = -1;
        int m = nums1.length, n = nums2.length;

        // O(n^2)
        // for (int x = 0; x < m; x++) {
        //     for (int y = x; y < n; y++) {
        //         if (nums1[x] <= nums2[y]) {
        //             if (y - x > max_dist) max_dist = y - x;
        //         }
        //         else break;
        //     }
        // }

        // O(n)
        int ptr1 = 0, ptr2 = 0;
        while (ptr1 < m && ptr2 < n) {
            if (nums1[ptr1] > nums2[ptr2]) {
                // if (ptr2 - ptr1 > max_dist) max_dist = ptr2 - ptr1;
                ptr1++;
                ptr2 = ptr1;
            }
            else {
                // int c = -1;
                // while(ptr2 < n && nums1[ptr1] <= nums2[ptr2]) {
                //     c++;
                //     ptr2++;
                // }
                // if (c > max_dist) max_dist = c;
                // ptr1++;
                // ptr2 = ptr1;
                max_dist = Math.max(max_dist, ptr2 - ptr1);
                ptr2++;
                
            }
        }

        // System.out.println(max_dist);

        return max_dist == -1 ? 0 : max_dist;
    }
}