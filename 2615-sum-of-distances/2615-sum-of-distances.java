class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> indices = new HashMap<>();

        for (int x = 0; x < n; x++) indices.computeIfAbsent(nums[x], k -> new ArrayList<>()).add(x);

        long[] arr = new long[n];

        for (List<Integer> index : indices.values()) {
            long S = 0;
            for (int idx : index) S += idx;

            long prefixSum = 0;
            int size = index.size();

            for (int x = 0; x < size; x++) {
                int idx = index.get(x);
                arr[idx] = S - prefixSum * 2 + (long) idx * (2 * x - size);
                prefixSum += idx;
            }
        }

        return arr;
    }
}