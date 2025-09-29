class Solution {
    public ListNode doubleIt(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode temp = head;
        while (temp != null) {
            sb.append(temp.val);
            temp = temp.next;
        }

        String num = sb.toString();
        StringBuilder doubled = new StringBuilder();
        int carry = 0;

        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';
            int prod = digit * 2 + carry;
            doubled.append(prod % 10);
            carry = prod / 10;
        }
        if (carry > 0) {
            doubled.append(carry);
        }
        doubled.reverse();

        ListNode newHead = new ListNode(doubled.charAt(0) - '0');
        ListNode current = newHead;
        for (int i = 1; i < doubled.length(); i++) {
            current.next = new ListNode(doubled.charAt(i) - '0');
            current = current.next;
        }

        return newHead;
    }
}
