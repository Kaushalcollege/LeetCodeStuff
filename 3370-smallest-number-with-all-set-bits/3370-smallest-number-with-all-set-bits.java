class Solution {
    public int smallestNumber(int n) {
        int[] arr = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
        return binSearchNextGreater(arr, n) - 1;
    }

    private int binSearchNextGreater(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        int ans = -1; // default if no greater element exists

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > key) {
                ans = arr[mid];   // possible answer
                high = mid - 1;   // try to find a smaller greater element
            } else {
                low = mid + 1;    // move right
            }
        }

        return ans; // returns -1 if there is no greater number
    }
}
