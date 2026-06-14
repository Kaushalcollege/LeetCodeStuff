/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode halfHead = head;
        ListNode temp = head;
        int n = 0, max = 0;

        while (temp != null) {
            temp = temp.next;
            n++;
        }
        // if (n == 2) return head.val + head.next.val;

        // System.out.println(n);

        for (int x = 0; x < n / 2; x++) halfHead = halfHead.next;
        // System.out.println(halfHead.val);

        // Reversing the second half of the list :
        ListNode curr = halfHead, last = halfHead;
        while(curr != null) {
            ListNode next = curr.next;
            // curr = next;
            curr.next = last;
            last = curr;
            curr = next;
        }
        // System.out.println(last.val);
        // System.out.println(last.next.val);
        for (int x = 0; x < n / 2; x++) {
            // System.out.println(head.val + " " + last.val);
            max = Math.max(head.val + last.val, max);
            head = head.next;
            last = last.next;
        }

        return max;
    }
}