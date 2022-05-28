class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        vowels={'a':0, 'e':0, 'i':0, 'o':0, 'u':0}
        i,j=0,0
        n=len(s)
        max_sum=0
        
        while j<n:
            if s[j] in vowels:
                vowels[s[j]]+=1
            
            if j-i+1<k:
                j+=1
                
            elif j-i+1==k:
                count=sum(vowels.values())
                max_sum=max(max_sum,count)
                if s[i] in vowels:
                    vowels[s[i]]-=1
                
                j+=1 
                i+=1
                
        return max_sum
            