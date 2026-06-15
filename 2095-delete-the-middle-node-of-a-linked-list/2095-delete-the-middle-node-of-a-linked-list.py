# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        temp, n = head, 0
        while temp is not None :
            temp = temp.next
            n += 1

        if n == 1 : return None
        # print(n // 2)
        # This is same as deleting a node at an index in a list.
        middle_node = head
        for x in range(n // 2 - 1) :
            middle_node = middle_node.next

        prev = middle_node
        middle_node = middle_node.next
        if middle_node is not None : 
            prev.next = middle_node.next
            middle_node.next = None
        
        else : prev.next = middle_node
        return head