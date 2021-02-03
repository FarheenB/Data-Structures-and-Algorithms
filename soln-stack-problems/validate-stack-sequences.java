/*
https://leetcode.com/problems/validate-stack-sequences/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int i=0;
        for(int num:pushed){
            stack.push(num);
            while(!stack.isEmpty() && i<pushed.length && stack.peek()==popped[i]){
                stack.pop();
                i++;                
            }
        }
        return i==pushed.length;
    }
}