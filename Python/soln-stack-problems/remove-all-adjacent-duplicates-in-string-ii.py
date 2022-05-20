# https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii

# Time: O(n)
# Space: O(n)

class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        stack = []
        
        for char in s:          
            if stack and stack[-1][0] == char:
                stack[-1][1] += 1
                if stack[-1][1] == k:
                    stack.pop()
            else:
                stack.append([char, 1])
        
        return ''.join(char * count for char, count in stack)