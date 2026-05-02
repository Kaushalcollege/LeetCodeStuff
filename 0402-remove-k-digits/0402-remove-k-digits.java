class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {

            // remove bigger previous digits
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }

            stack.push(digit);
        }

        // if removals still left, remove from end
        while (k > 0) {
            stack.pop();
            k--;
        }

        // build result
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);

        // remove leading zeros
        String result = sb.toString().replaceFirst("^0+(?!$)", "");

        // handle empty case
        return result.isEmpty() ? "0" : result;
    }
}