/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/min-stack/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class MinStack {
    Stack<Long> stack;
    long minEle;

    public MinStack() {
        stack=new Stack<Long>();
        minEle=Long.MIN_VALUE;
    }
    
    public void push(int x) {
        long temp=x;
        if(stack.isEmpty()){
            stack.push(temp);
            minEle=x;
        }
        else{
            if(x<=minEle){
                stack.push(2*temp-minEle);
                minEle=x;
            }
            else
                stack.push(temp);            
        }
    }
    
    public void pop() {
        if(stack.isEmpty())
            return;
        else{
            if(stack.peek()<=minEle)
                minEle=(2*minEle)-stack.peek();
            stack.pop();
        }                 
    }
    
    public int top() {
        if(stack.isEmpty())
            return -1;
        else{
            if(stack.peek()<=minEle)
                return (int)minEle;
            return stack.peek().intValue();
        }       
    }
    
    public int getMin() {
        if(stack.isEmpty())
            return -1;
        return (int)minEle;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
