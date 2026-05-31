class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long m = mass;
        Arrays.sort(asteroids);

        for (int x : asteroids) {
            if (m >= x) m += x;
            else return false;
        }

        return true;
    }
}