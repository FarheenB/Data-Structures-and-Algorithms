/*
https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class solve{
    public static long[] nextLargerElement(long[] nums, int n) { 
        long[] output=new long[nums.length];
        //for storing the indicies
        Stack<Integer> stack=new Stack<>();
        
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty())
                output[i]=-1;
            else
                output[i]=nums[stack.peek()];
            stack.push(i);             
        }
        return output;
    } 
}