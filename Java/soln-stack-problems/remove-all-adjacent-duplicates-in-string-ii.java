/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Pair{
    char chars;
    int count;
    Pair(char chars, int count){
        this.chars=chars;
        this.count=count;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        if(k>=s.length())
            return s;
        if(k==1)
            return "";
        
        char remove=' ';
        Stack<Pair> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(stack.isEmpty())
                stack.push(new Pair(ch,1));
            else{
                if(stack.peek().chars==ch && stack.peek().count==k-1){
                    while(!stack.isEmpty() && stack.peek().chars==ch){
                        stack.pop();
                    }
                }                    
                else if(!stack.isEmpty() && ch==stack.peek().chars)
                    stack.push(new Pair(ch,stack.peek().count+1));
                else
                    stack.push(new Pair(ch,1));                    
           }
                
        }  
        StringBuilder str=new StringBuilder();
        while(!stack.isEmpty()){
            str.append(stack.pop().chars);
        }            
        return str.reverse().toString();        
    }
}
