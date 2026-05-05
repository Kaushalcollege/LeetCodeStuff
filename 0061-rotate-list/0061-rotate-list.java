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

        ListNode lastNode = head;
        int size = 1;

        while (lastNode.next != null) {
            lastNode = lastNode.next;
            size++;
        }

        lastNode.next = head;
        k = k % size;
        int newHead = size - k;

        ListNode tail = head;
        for (int x = 1; x < newHead; x++) tail = tail.next;

        head = tail.next;
        tail.next = null;

        return head;
    }
}