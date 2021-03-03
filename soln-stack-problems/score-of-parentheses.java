/*
https://leetcode.com/problems/score-of-parentheses
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack=new Stack<>();
        int score=0;
        stack.push(0);
        
        for(char ch:S.toCharArray()){
            if(ch=='('){
                stack.push(0);
            }
            else{
                int x=stack.pop();
                int y=stack.pop();
                stack.push(y+(Math.max(2*x,1)));
            }
            System.out.println(stack);
        }
        return stack.pop();
    }
}