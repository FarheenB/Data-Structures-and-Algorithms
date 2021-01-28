/*
https://leetcode.com/problems/largest-rectangle-in-histogram/
https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;

        int[] nearest_sm_left=NSL(heights);
        int[] nearest_sm_right=NSR(heights);
        for(int s=0;s<heights.length;s++){
            int area=(nearest_sm_right[s]-nearest_sm_left[s]-1)*heights[s];
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }   
    
    public int[] NSR(int[] nums) { 
        int[] indices=new int[nums.length];
        //for storing the indicies
        Stack<Integer> stack=new Stack<>();
        
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty())
                indices[i]=nums.length;
            else
                indices[i]=stack.peek();
            stack.push(i);             
        }
        
        return indices;
    }
    
     public int[] NSL(int[] nums) {
        int[] indices=new int[nums.length];
        //for storing the indicies
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty())
                indices[i]=-1;
            else
                indices[i]=stack.peek();
            stack.push(i);             
        }
        return indices;
    }
}