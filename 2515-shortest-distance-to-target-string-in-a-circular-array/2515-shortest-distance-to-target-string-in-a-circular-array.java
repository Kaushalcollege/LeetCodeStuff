class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int global_min = 101;

        for (int x = 0; x < n; x++) {
            if (words[x].equals(target)) {
                int diff = ((x - startIndex) > 0) ? x - startIndex : startIndex - x;
                int dist = (diff < (n - diff)) ? diff : n - diff;
                global_min = dist < global_min ? dist : global_min;
            }
        }

        return global_min == 101 ? -1 : global_min;
    }
}