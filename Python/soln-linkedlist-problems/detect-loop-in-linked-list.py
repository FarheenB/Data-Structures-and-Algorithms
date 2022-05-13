'''
 @author Farheen Bano
 
 Date 08-05-2022

 Reference-
 https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
 https://leetcode.com/problems/linked-list-cycle
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Solution 1:

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        
        s = set()
        temp = head
        while (temp):
 
            # If we have already has
            # this node in hashmap it
            # means their is a cycle
            # (Because you we encountering
            # the node second time).
            if (temp in s):
                return True
 
            # If we are seeing the node for
            # the first time, insert it in hash
            s.add(temp)
 
            temp = temp.next
 
        return False
        

# -------------------------------------------------------------------------------


# Solution 2:

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        
        if(head is None):
            return False
        
        slowptr=head
        fastptr=head
        
        while(fastptr is not None and fastptr.next is not None):
            slowptr=slowptr.next
            fastptr=fastptr.next.next
            if fastptr==slowptr:
                return True
        
        return False
        