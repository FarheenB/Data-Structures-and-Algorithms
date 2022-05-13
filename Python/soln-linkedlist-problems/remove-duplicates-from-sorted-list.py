'''
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/remove-duplicates-from-sorted-list
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None:
            return head
        
        p=head
        while p.next is not None:
            if p.val==p.next.val:
                p.next=p.next.next
            else:
                p=p.next
        
        return head