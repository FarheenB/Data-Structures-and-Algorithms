'''
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/odd-even-linked-list/
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if(head is None or head.next is None):
            return head
               
        odd=head
        even=head.next
        evenHead=even
        
        while(even is not None and even.next is not None):
            odd.next=even.next
            odd=odd.next
            even.next=odd.next
            even=even.next
        
        odd.next=evenHead
        return head