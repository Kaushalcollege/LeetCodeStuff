# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        n, temp, twin_max = 0, head, 0

        while(temp is not None) :
            temp = temp.next
            n += 1

        half_head = head
        for x in range(int(n / 2)) :
            half_head = half_head.next

        curr, last = half_head, half_head
        while curr is not None :
            consequent = curr.next
            curr.next = last
            last = curr
            curr = consequent

        for x in range(int(n / 2)) :
            twin_max = max(twin_max, head.val + last.val)
            head = head.next
            last = last.next

        return twin_max