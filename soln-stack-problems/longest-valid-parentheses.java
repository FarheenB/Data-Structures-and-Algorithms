/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/longest-valid-parentheses/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int maxLen=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }
            else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    maxLen=Math.max(maxLen,i-stack.peek());
                }
            }
        }
        return maxLen;         
    }
}
