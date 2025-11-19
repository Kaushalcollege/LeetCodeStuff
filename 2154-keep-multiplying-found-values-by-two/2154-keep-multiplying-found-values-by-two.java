// class Solution {
//     public int findFinalValue(int[] nums, int original) {
//         List<Integer> ii = new ArrayList<>();
//         for (int i : nums) ii.add(i);
//         while (ii.contains(original)) if (ii.contains(original)) original *= 2;
//         return original;
//     }
// }

class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);

        while (set.contains(original)) {
            original *= 2;
        }

        return original;
    }
}
