class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        n = len(s)
        i,j = 0,0
        d = {'a':0,'e':0,'i':0,'o':0,'u':0}
        res = 0
        while j<n:
            if s[j] in d:
                d[s[j]]+=1
            if j-i+1<k:
                j+=1
            elif j-i+1==k:
                res = max(res,sum(d.values()))
                if s[i] in d:
                    d[s[i]]-=1
                i+=1
                j+=1
        return res