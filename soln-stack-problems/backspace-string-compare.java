/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/backspace-string-compare/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1=insert(S);        
        Stack<Character> stack2=insert(T);
        
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            if(stack1.pop()!=stack2.pop())
                return false;
        } 
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    private Stack<Character> insert(String str){
        Stack<Character> stack=new Stack<>();
        char[] ch=str.toCharArray();
        for(char c:ch){
            if(c=='#'){
                if(!stack.isEmpty())
                    stack.pop();  
            }
            else
                stack.push(c);
        }
        return stack;
    }    
}
