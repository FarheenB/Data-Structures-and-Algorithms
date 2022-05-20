# https://leetcode.com/problems/evaluate-reverse-polish-notation/

# Stack Solution
# Time:     O(n),       Iterates through tokens at most one time.
# Space:    O(n),       list / stack could contain all tokens.

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        tokenStack = []                           
        operators = {'+', '-', '*', '/'}           
        
        def truncateTowardZero(x: float) -> int:        
            return floor(x) if 0 < x else ceil(x)
        
        def validPopConditions() -> bool:                 
            if len(tokenStack) < 3: return False     
            if tokenStack[-1] in operators: return False   
            if tokenStack[-2] in operators: return False  
            
            return True
        
        for token in tokens[::-1]:                              
            tokenStack.append(token)      
            
            while validPopConditions(): 
                a, b = int(tokenStack.pop()), int(tokenStack.pop()) 
                operator = tokenStack.pop()               
                
                match operator:                  
                    case '+': tokenStack.append(a+b)
                    case '-': tokenStack.append(a-b)
                    case '*': tokenStack.append(a*b)
                    case '/': tokenStack.append(truncateTowardZero(a/b))
                    
        return tokenStack[0]  