class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Boolean> surplus = new LinkedHashMap<>();

        for (int num : nums) set.add(num);
        for (int i = k; i < 201; i += k){
            if (!set.contains(i)) surplus.put(i, false);
            else surplus.put(i, true);
        }

        for (Map.Entry<Integer, Boolean> e : surplus.entrySet()){
            if (e.getValue() == false) return e.getKey();
        }

        return 0;
        
    }
}