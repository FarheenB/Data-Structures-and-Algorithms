class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res=[]
        
        if n==0:
            return res
        
        def solve(open_br, close_br, str):
            
            if open_br==close_br and open_br==0:
                res.append(str)
                return
            
            if open_br>0:
                solve(open_br-1,close_br,str+"(")
            
            if close_br>open_br:
                solve(open_br,close_br-1,str+")")
                
        solve(n,n,"")
        return res