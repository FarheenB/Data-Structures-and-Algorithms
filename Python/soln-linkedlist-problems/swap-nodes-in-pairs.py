'''
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/swap-nodes-in-pairs/
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if(head is None or head.next is None):
            return head
    
        p=head
        q=p.next

        while(p is not None and q is not None):
            temp=p.val
            p.val=q.val
            q.val=temp
            
            p=q.next
            if(p is not None):
                q=p.next
        
        return head