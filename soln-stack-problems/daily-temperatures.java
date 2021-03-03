/*
https://leetcode.com/problems/daily-temperatures
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack=new Stack<>();
        int[] result=new int[T.length];
        
        for(int i=T.length-1;i>=0;i--){
            while(!stack.isEmpty() && T[stack.peek()]<=T[i])               
                stack.pop();
            
            if(stack.isEmpty())
                result[i]=0;
            else
                result[i]=stack.peek()-i;
            stack.push(i);
        }
        return result;
    }
}