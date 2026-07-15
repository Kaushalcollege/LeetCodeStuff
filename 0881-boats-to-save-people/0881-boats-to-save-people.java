class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int l = 0, r = n - 1, count = 0;

        // while(r >= 0 && people[r] >= limit) {
        //     count++;
        //     r--;
        // }
        while (l <= r) {
            // if (l == r) {
            //     count++;
            //     continue;
            // }
            int combinedWeight = people[l] + people[r];
            if (combinedWeight <= limit) {
                l++;
                r--;
                count++;
            }
            else {
                r--;
                count++;
            }
        }

        return count;
    }
}