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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) return head;
        int length = 1;
        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
            // System.out.println(temp.val);
            length++;
            // System.out.println(length);
        }

        k = k % length;

        int prevNodeVal = head.val;
        temp = head.next;

        while (k-- > 0) {
            while (temp != null) {
                int currVal = temp.val;
                temp.val = prevNodeVal;
                prevNodeVal = currVal;
                temp = temp.next;
            }

            // After while loop is done, what is the value of prevNodeVal?
            temp = head;
            temp.val = prevNodeVal;
        }

        return head;
    }
}