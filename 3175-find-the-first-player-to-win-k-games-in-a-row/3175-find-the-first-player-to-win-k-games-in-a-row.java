class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        Deque<Integer> ii = new LinkedList<>();

        // Initialize the queue with all the players -- indices.
        for (int i = 1; i < skills.length; i++) ii.addLast(i);

        int curr = 0, count = 0; // curr is the current winner and count is 0.

        while (true){
            int num = ii.pollFirst();
            if (skills[curr] > skills[num]){
                count++;
                ii.addLast(num);
            }
            else{
                count = 1; // For new Winner.
                ii.addLast(curr); // Previous winner goes to back.
                curr = num; // current winner gets updated.
            }
            if (count == k || count >= skills.length - 1) return curr;
        }
    }
}