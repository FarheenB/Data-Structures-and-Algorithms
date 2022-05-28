class Solution:
    def countSubstrings(self, s: str) -> int:
        global result
        result=0
        
        def expandAndCountFromCenter(i,j):
            global result

            while i>=0 and j<=len(s)-1 and s[i]==s[j]:
                result+=1
                i-=1
                j+=1
                 
        for i in range(len(s)):
            expandAndCountFromCenter(i,i)
            expandAndCountFromCenter(i,i+1)
            
        return result
        