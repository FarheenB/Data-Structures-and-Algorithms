class Solution:
    def validPalindrome(self, s: str) -> bool:
    
        def isPalindrome(s,i,j):
            while i<=j:
                if s[i]==s[j]:
                    i=i+1
                    j-=1

                else:
                    return False
            return True
        
        i=0
        j=len(s)-1     
        while i<j:
            if s[i]!=s[j]:
                return isPalindrome(s,i,j-1) or isPalindrome(s,i+1,j)
            i+=1
            j-=1
        return True
        
                
            