/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public String minRemoveToMakeValid(String S) {
        Stack<Integer> stack=new Stack<>();
        Set<Integer> indexToRemove=new HashSet<>();
        StringBuilder str=new StringBuilder();
        
        for(int i=0;i<S.length();i++){
            char ch=S.charAt(i);
            if(ch=='(')
                stack.push(i);
            else if(ch==')'){
                if(stack.isEmpty())
                    indexToRemove.add(i);
                else
                    stack.pop();
            }
        }
        
        while(!stack.isEmpty()){
            indexToRemove.add(stack.pop());        
        }
        
        for(int i=0;i<S.length();i++){
            if(!indexToRemove.contains(i))
                str.append(S.charAt(i));
        }
        
        return str.toString();
    }
}
