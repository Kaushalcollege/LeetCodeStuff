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
        if (k == 0 || head == null) return head;
        ListNode lastNode = head;
        // ListNode secondLastNode = head;

        // while (lastNode.next != null) lastNode = lastNode.next;
        // while (secondLastNode.next != lastNode) secondLastNode = secondLastNode.next;
        // // System.out.println(lastNode.val);
        // // System.out.println(secondLastNode.val);

        // while (k-- > 0) {
        //     se
        // }

        int size = 0;
        while (lastNode != null) {
            lastNode = lastNode.next;
            size++;
        }

        // System.out.println(size);
        k = k % size;
        int prevNodeVal = head.val;
        ListNode temp = head.next;

        while (k-- > 0) {
            while (temp != null) {
                int currVal = temp.val;
                temp.val = prevNodeVal;
                prevNodeVal = currVal;
                temp = temp.next;
            }
            temp = head;
            temp.val = prevNodeVal;
        }

        return head;
    }
}