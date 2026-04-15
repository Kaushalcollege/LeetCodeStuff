class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        List<Integer> target_indices = new ArrayList<>();
        int global_min = 101;

        for (int x = 0; x < n; x++) if (words[x].equals(target)) target_indices.add(x);


        for (int x : target_indices) {
            int left_path = 0, right_path = 0;
            if (x > startIndex) {
                left_path = n - (x - startIndex);
                right_path = x - startIndex;
            }

            else {
                right_path = n - (startIndex - x);
                left_path = startIndex - x;
            }

            global_min = Math.min(global_min, Math.min(left_path, right_path));
        }

        return global_min == 101 ? -1 : global_min;
    }
}