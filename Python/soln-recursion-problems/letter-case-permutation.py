class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        res=[]
        
        if len(s)==0:
            return res
        
        def solve(i, cur):
            if i==len(s):
                res.append(cur)
                return
            if s[i].isalpha():
                solve(i+1,cur+s[i].lower())
                solve(i+1,cur+s[i].upper())   
                
            else:
                solve(i+1,cur+s[i])
                
        solve(0,"")
        return res