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
    public ListNode deleteMiddle(ListNode head) {
        ListNode temp = head;
        int n = 0;

        while (temp != null) {
            temp = temp.next;
            n++;
        }

        if (n == 1) return null;
        ListNode middleNode = head;

        for (int x = 0; x < n/ 2 - 1; x++) middleNode = middleNode.next;

        ListNode prev = middleNode;
        middleNode = middleNode.next;
        if (middleNode != null) {
            prev.next = middleNode.next;
            middleNode.next = null;
        }
        else prev = middleNode;

        return head;
    }
}