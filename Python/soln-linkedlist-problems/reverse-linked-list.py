'''
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/reverse-a-linked-list/
 https://leetcode.com/problems/reverse-linked-list/

'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Solution 1:

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev = None
        current = head
        while(current is not None):
            next = current.next
            current.next = prev
            prev = current
            current = next
        head = prev
        
        return head


# --------------------------------------------------------------------------------

# Solution 2:

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if(head is None or head.next is None):
            return head;
        
        p=self.reverseList(head.next);
        head.next.next=head;
        head.next=None;
        return p;
        