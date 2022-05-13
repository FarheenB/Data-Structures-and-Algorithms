'''
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/palindrome-linked-list/
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        compare_list = []
        
        while head:
            compare_list.append(head.val)
            head = head.next
            
        return compare_list[::] == compare_list[::-1]