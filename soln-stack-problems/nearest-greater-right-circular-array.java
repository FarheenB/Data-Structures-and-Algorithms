/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/next-greater-element-ii/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] output=new int[nums.length];
        //for storing the indicies
        Stack<Integer> stack=new Stack<>();
        
        for(int i=2*nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i%nums.length]){
                stack.pop();
            }
            if(stack.isEmpty())
                output[i%nums.length]=-1;
            else
                output[i%nums.length]=nums[stack.peek()];
            stack.push(i%nums.length);             
        }
        return output;
    }
}
