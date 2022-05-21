'''
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/longest-valid-parentheses/
'''

class Solution:
    def longestValidParentheses(self, s: str) -> int:
        stack=[]
        stack.append(-1)
        maxLen=0
        
        for i in range(0,len(s)):
            if s[i]=='(':
                stack.append(i)
            else:
                stack.pop()
               
                if len(stack)<1:
                    stack.append(i)
                else:
                    maxLen= max(maxLen,i-stack[-1])
        return maxLen
        