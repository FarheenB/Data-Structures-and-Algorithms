/*
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack=new Stack<>();
        
        for(char ch:S.toCharArray()){
            if(stack.isEmpty())
                stack.push(ch);
            else if(stack.peek()==ch){
                while(!stack.isEmpty() && stack.peek()==ch)
                    stack.pop();
            } 
            else
                stack.push(ch);
        }
        StringBuilder str=new StringBuilder();
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        
        return str.reverse().toString();
    }
}