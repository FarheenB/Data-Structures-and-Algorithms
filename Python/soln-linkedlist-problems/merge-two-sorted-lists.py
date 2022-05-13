'''
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/merge-two-sorted-lists/
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        
        p=list1
        q=list2
        resultHead=None
        dummyNode=ListNode(-1)
        resultHead=dummyNode
        
        while (p is not None and q is not None): 
            
            if (p.val <= q.val): 
                dummyNode.next = p
                p = p.next
             
            else: 
                dummyNode.next = q
                q = q.next
            
            dummyNode = dummyNode.next
    
        dummyNode.next = q if p is None else p
    
        return resultHead.next
        