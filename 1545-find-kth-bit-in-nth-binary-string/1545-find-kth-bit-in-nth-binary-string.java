class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder ii = new StringBuilder();
        String s = "0";
        Map<Integer, String> map = new HashMap<>();
        map.put(1, s);

        for (int i = 2; i <= n; i++) {
            // int num = Integer.parseInt(map.get(i - 1), 2);
            // num = ~num;
            String inverse = flip(map.get(i - 1));
            StringBuilder h = new StringBuilder(inverse);
            String rev = h.reverse().toString();
            s = s + "1" + rev;
            map.put(i, s);
        }
        // System.out.println(map.get(n));
        return map.get(n).charAt(k - 1);
    }

    private String flip (String s) {
        StringBuilder ss = new StringBuilder(s);
        for (int i = 0; i < ss.length(); i++) {
            if (ss.charAt(i) == '0') ss.setCharAt(i, '1');
            else ss.setCharAt(i, '0');
        }

        return ss.toString();
    }
}