/*
https://leetcode.com/discuss/interview-question/625140/Goldman-Sachs-or-OA-2020-or-Array-Burst-Problem-and-Birthday-Party
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
                if(stack.peek().chars!=ch && stack.peek().count>=k && remove==stack.peek().chars){
                    while(!stack.isEmpty() && stack.peek().chars==remove){
                        stack.pop();
                    }
                }                    
                if(!stack.isEmpty() && ch==stack.peek().chars){
                    stack.push(new Pair(ch,stack.peek().count+1));
                    if(stack.peek().count>=k){
                        remove=stack.peek().chars;
                    }
                }
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