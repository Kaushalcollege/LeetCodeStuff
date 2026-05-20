class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];

        Map<Integer, Boolean> map = new HashMap<>();
        int c = 0;


        for (int x = 0; x < n; x++) {
            if (map.containsKey(A[x]) && map.get(A[x]) == true) c++;
            else map.put(A[x], true);
            if (map.containsKey(B[x]) && map.get(B[x]) == true) c++;
            else map.put(B[x], true);
            C[x] = c;
        }

        return C;
    }
}