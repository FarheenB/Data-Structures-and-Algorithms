'''
 @author Farheen Bano
  
 References-
 https://leetcode.com/problems/remove-duplicate-letters
 https://leetcode.com/problems/smallest-subsequence-of-distinct-characters
'''

class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        s_map = dict()
        for ch in s:
            if ch in s_map:
                s_map[ch] += 1
            else:
                s_map[ch] = 1
   
        stack = []
        visited = set()
        
        for ch in s:
            if ch not in visited:
                while stack and stack[-1] > ch and s_map[stack[-1]] > 1:
                    s_map[stack[-1]] -= 1
                    visited.remove(stack.pop())
                    
                stack.append(ch)
                visited.add(ch)
            else:
                s_map[ch] -= 1
        
        return ''.join(stack)
        