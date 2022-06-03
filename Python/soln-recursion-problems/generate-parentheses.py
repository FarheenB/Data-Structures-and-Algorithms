class Solution:

    def generateParenthesis(self, n: int) -> List[str]:
        global result
        result=[]

        if(n==0):
            return result
     
    
        def solve( open_br,  close_br,  str):
        
            if(open_br==0 and close_br==0):
                result.append(str)
                return 

            if(open_br!=0):
                solve(open_br-1,close_br,str+"(")

            if(close_br>open_br):
                solve(open_br,close_br-1,str+")")
                
        solve(n,n,"")
        return result   
