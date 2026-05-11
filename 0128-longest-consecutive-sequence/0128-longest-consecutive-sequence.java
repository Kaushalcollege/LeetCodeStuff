class Solution {
    public int longestConsecutive(int[] s) {

        int n = s.length, longest = 1;

        for (int x : s) {
            int cnt = 1;

            while (linearSearch(s, x + 1) == true) {
                x += 1;
                cnt += 1;
            }

            longest = Math.max(cnt, longest);
        }

        return longest;
    }

    public boolean linearSearch(int arr[], int target) {
        boolean found = false;

        for (int x : arr) if (x == target) found = true;

        return found;
    }
}