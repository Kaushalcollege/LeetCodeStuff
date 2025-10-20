class Solution {
    public int finalValueAfterOperations(String[] operations) {
        Map<String, Integer> store = new HashMap<>();

        store.put("++X", 1);
        store.put("X++", 1);
        store.put("--X", -1);
        store.put("X--", -1);

        int sum = 0;

        for (String s : operations) sum += store.get(s);

        return sum;
    }
}