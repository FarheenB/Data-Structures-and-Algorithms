'''
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/valid-parentheses/
'''

class Solution:
    def isValid(self, s: str) -> bool:    
        stack = []
        for ch in s:
            if stack and stack[-1] == '{' and ch == '}':
                stack.pop()
            elif stack and stack[-1] == '(' and ch == ')':
                stack.pop()
            elif stack and stack[-1] == '[' and ch == ']':
                stack.pop()
            else:
                stack.append(ch)
                
        return len(stack)==0
    