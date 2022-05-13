'''
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/rotate-list/
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if head is None or head.next is None:
            return head
        
        count=1
        tail=head
        while tail.next is not None:
            tail=tail.next
            count=count+1
        
        tail.next=head
        k=k%count
        i=1
        p=head

        while(i<(count-k)):
            i=i+1
            p=p.next
        
        head=p.next
        p.next=None
        return head