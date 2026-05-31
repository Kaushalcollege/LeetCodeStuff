class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {

        // // this is a greedy approach.
        // long m = mass;
        // Arrays.sort(asteroids); // O(nlogn)

        // for (int x : asteroids) { // O(n)
        //     if (m >= x) m += x;
        //     else return false;
        // }

        // return true; // finally O(nlogn)

        // How do I get it to O(n)?

        int min = 10001;
        int max = 0;

        for (int x : asteroids) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        int[] freq = new int[max + 1];
        long m = mass;

        for (int x : asteroids) {
            if (m >= x) m += x;
            else freq[x]++;
        }

        if (m >= max) return true;
        for (int x = min; x <= max; x++) {
            if (m < x) return false;
            if (freq[x] != 0) m += (x * freq[x]);
        }

        return true;
    }
}