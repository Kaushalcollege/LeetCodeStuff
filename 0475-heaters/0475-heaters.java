class Solution {
    public int findRadius(int[] houses, int[] heaters) {
       // Binary Search Approach.
       // If we have a max list, with all the minimum radii of all the heaters and find the max.
       List<Integer> res = new ArrayList<>();
       Arrays.sort(heaters);
       for (int house : houses){
        res.add(Math.abs(house - binSearchNearestEle(heaters, house)));
       }

       int max = 0;
       for (int i : res) max = Math.max(max, i);
       return max;
    }
    private int binSearchNearestEle (int[] arr, int target){
        int res = arr[0];
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // Update res if mid is closer to target
            if (Math.abs(arr[mid] - target) < Math.abs(res - target)) {
                res = arr[mid];

            // In case of a tie, prefer larger value
            } else if (Math.abs(arr[mid] - target) == Math.abs(res - target)) {
                res = Math.max(res, arr[mid]);
            }

            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return res;
    }
}