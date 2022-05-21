'''
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/evaluate-reverse-polish-notation/
'''

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        operandStack=[]
        operators={'+','-','*','/'}
        
        for token in tokens:
            if token in operators:
                if operandStack:
                    y=int(operandStack.pop())
                if operandStack:
                    x=int(operandStack.pop())
                    
                match token:
                    case '*':
                        operandStack.append(x*y)     
                    case '/':
                        operandStack.append(int(x/y)) 
                    case '+':
                        operandStack.append(x+y)  
                    case '-':
                        operandStack.append(x-y)                        
                    
            else:
                operandStack.append(token)
                
        return operandStack[-1]

# Stack Solution
# Time:     O(n),       Iterates through tokens at most one time.
# Space:    O(n),       list / stack could contain all tokens.
