# class Solution:
#     def countSubstrings(self, s: str) -> int:
        
#         global result
#         result = 0
        
#         def expandFromCenter(i, j):
#             global result
#             while 0 <= i < len(s) and 0 <= j < len(s) and s[i] == s[j]:                
#                 result += 1
#                 i -= 1
#                 j += 1        
        
#         for idx in range(len(s)):
#             expandFromCenter(idx, idx) # odd expansion
#             expandFromCenter(idx, idx+1) # even expansion
        
#         return result

class Solution:    
    def expandAndCountPallindromes(self, i, j, s):
        
        length=len(s)
        cnt=0
        
        while 0<=i and j<length and s[i]==s[j]:
            i-=1
            j+=1
            cnt+=1
        
        return cnt
        
    def countSubstrings(self, s: str) -> int:
        
        return sum(self.expandAndCountPallindromes(i,i,s) + self.expandAndCountPallindromes(i,i+1,s) for i in range(len(s)))