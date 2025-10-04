class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
            -- Very General sliding window application.
            -- Start from left ptr = 0 and right ptr = k - 1.
            -- We have to add the max element of all the sub arrays into List.
            -- We have to use deque.
        */

        if (nums.length == 1) return new int[]{nums[0]};

        // List<Integer> ii = new ArrayList<>();
        // int lptr = 0, rptr = k - 1;

        // while(rptr < nums.length){
        //     ii.add(Math.max(nums[lptr], Math.max(nums[lptr + 1], nums[rptr])));
        //     lptr++;
        //     rptr++;
        // }
        // int[] res = new int[ii.size()];
        // int idx = 0;
        // for (int i : ii) res[idx++] = i;

        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0;

        for (int i = 0; i < n; i++) {
            // Remove indices that are out of this window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove elements smaller than current (not useful)
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            // Add to result once we reach size k
            if (i >= k - 1) {
                res[idx++] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}