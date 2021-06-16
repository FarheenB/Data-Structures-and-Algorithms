/**
 @author Farheen Bano
  
 Reference-
 https://www.geeksforgeeks.org/next-smaller-element/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class solve{
    public static int[] nextSmallerElement(int[] nums) { 
        int[] output=new int[nums.length];
        //for storing the indicies
        Stack<Integer> stack=new Stack<>();
        
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
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
