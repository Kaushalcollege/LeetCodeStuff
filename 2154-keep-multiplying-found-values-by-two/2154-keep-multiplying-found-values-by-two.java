class Solution {
    public int findFinalValue(int[] nums, int original) {
        List<Integer> ii = new ArrayList<>();
        for (int i : nums) ii.add(i);
        while (ii.contains(original)) if (ii.contains(original)) original *= 2;
        return original;
    }
}

