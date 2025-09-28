class Solution {
    public int[] decimalRepresentation(int n) {
        /*
            -- Non-negetive component means -- from 0 to some large number.
            -- A positive integer is a base-10 component if it is the product of a single digit from 1 to 9 and a non-negative power of 10.
            -- For example, 500, 30, and 7 are base-10 components, while 537, 102, and 11 are not.
            -- we have got to Express n as a sum of only base-10 components, using the fewest base-10 components possible.
            -- Return an array containing these base-10 components in descending order.
            -- we can start by breaking down the number digit by digit. (in a loop).
            -- for every iteration in the loop, multiply with 10 ^ (no of iteration).
            -- Each non-zero digit contributes a base-10 component.

        */
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int power = 0;

        while (n > 0) {
            int rem = n % 10;
            if (rem != 0) {
                pq.offer(rem * (int)Math.pow(10, power));
            }
            n /= 10;
            power++;
        }

        int[] res = new int[pq.size()];
        int idx = 0;
        while (!pq.isEmpty()) {
            res[idx++] = pq.poll();  // guaranteed descending order
        }

        return res;
    }
}