class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        // Brute Force ::
        List<String> res = new ArrayList<>();
        // Set<String> set = new LinkedHashSet<>();

        for (String q : queries) {
            for (String d : dictionary) {
                int c = 0;
                for (int x = 0; x < d.length(); x++) {
                    if (q.charAt(x) != d.charAt(x)) c++;
                }

                if (c <= 2) {
                    res.add(q);
                    break;
                }
            }
        }

        // for (String s : set) res.add(s);

        return res;
    }
}