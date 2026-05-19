class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int ptr1 = 0, ptr2 = 0;
        int m = nums1.length, n = nums2.length;

        while (ptr1 < m && ptr2 < n) {
            if (nums1[ptr1] < nums2[ptr2]) ptr1++;
            else if (nums1[ptr1] > nums2[ptr2]) ptr2++;
            else return nums1[ptr1];
        }

        return -1;
    }
}