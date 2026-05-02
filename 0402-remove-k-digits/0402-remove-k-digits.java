class Solution {
    public String removeKdigits(String num, int k) {
        // int n = Integer.parseInt(num);
        if (num.length() == 1) return "0";
        Stack<Character> s = new Stack<>();
        int idx = 0;

        while (idx < num.length()) {
            char n = num.charAt(idx);
            if (s.isEmpty()) {
                s.push(n);
                idx++;
                // System.out.println(s + " " + "is Empty");
                continue;
            }
            else if (!s.isEmpty() && s.peek() <= n && k > 0) {
                s.push(n);
                idx++;
                // System.out.println(s + " " + "less than");
                continue;
            }
            else if (!s.isEmpty() && s.peek() > n && k > 0){
                while(!s.isEmpty() && s.peek() > n && k > 0) {
                    s.pop();
                    k--;
                }
                s.push(n);
                idx++;
                // System.out.println(s + " " + "greater than");
                continue;
            }
            else {
                s.push(n);
                idx++;
                continue;
            }
        }
        if (k > 0) {
            while (k > 0) {
                s.pop();
                k--;
            }
        }

        String str = "";
        for (char c : s) str += String.valueOf(c);

        // return str + num.substring(idx);
        return str.equals("") ? "0" : str.replaceFirst("^0+(?!$)", "");
    }
}