'''
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/simplify-path/
'''

class Solution(object):
    def simplifyPath(self, path):
        stack = []
        for p in path.split("/"):
            if p == '..' and len(stack) > 0:
                stack.pop()
            if p == '' or p == '.' or p =='..':
                continue
            else:
                stack.append(p)
        return '/' + '/'.join(stack)