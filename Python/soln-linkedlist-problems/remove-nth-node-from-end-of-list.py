'''
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/remove-nth-node-from-end-of-list/
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        if head is None:
            return head
        
        dummyHead=ListNode(-1)
        dummyHead.next=head;       
        slowPtr=dummyHead
        fastPtr=dummyHead

        i=1
        while(i<=n+1):
            fastPtr=fastPtr.next
            i=i+1
        
        while(fastPtr is not None):
            fastPtr=fastPtr.next
            slowPtr=slowPtr.next    
        
        slowPtr.next=slowPtr.next.next
        return dummyHead.next