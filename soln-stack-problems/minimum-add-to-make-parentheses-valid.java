/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/minimum-add-to-make-parentheses-valid
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack=new Stack<>();
        int count=0;

        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='('){
                stack.push('(');
            }
            else{
                if(!stack.isEmpty() && stack.peek()=='(')
                    stack.pop();
                else
                    count++;
            }
        }
        while(!stack.isEmpty()){
            count++;
            stack.pop();
        }
        return count;
    }
}
