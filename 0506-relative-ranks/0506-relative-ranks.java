class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[] arr = Arrays.copyOf(score, n);
        Arrays.sort(arr); // ascending

        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int rank = n - i; // highest score gets rank 1

            if (rank == 1) map.put(arr[i], "Gold Medal");
            else if (rank == 2) map.put(arr[i], "Silver Medal");
            else if (rank == 3) map.put(arr[i], "Bronze Medal");
            else map.put(arr[i], String.valueOf(rank));
        }

        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = map.get(score[i]);
        }

        return res;
    }
}