/*
https://leetcode.com/problems/validate-stack-sequences/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();        
        int index=0;
        
        for(int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty() && popped[index]==stack.peek() && index<popped.length){
                stack.pop();
                index++;
            }                
        }
        return stack.isEmpty()? true:false;        
    }
}