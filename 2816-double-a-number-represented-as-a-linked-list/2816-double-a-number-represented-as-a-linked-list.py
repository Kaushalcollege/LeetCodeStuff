# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # Step 1: Convert linked list to string number
        num_str = ""
        temp = head
        while temp:
            num_str += str(temp.val)
            temp = temp.next
        
        # Step 2: Double the number manually
        carry = 0
        doubled_digits = []
        for digit in reversed(num_str):
            prod = int(digit) * 2 + carry
            doubled_digits.append(str(prod % 10))
            carry = prod // 10
        if carry:
            doubled_digits.append(str(carry))
        
        # Step 3: Rebuild the linked list from doubled number
        doubled_digits.reverse()
        new_head = ListNode(int(doubled_digits[0]))
        curr = new_head
        for d in doubled_digits[1:]:
            curr.next = ListNode(int(d))
            curr = curr.next
        
        return new_head
