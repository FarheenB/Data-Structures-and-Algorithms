/*
https://www.interviewbit.com/problems/max-rectangle-in-binary-matrix/
https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/
https://leetcode.com/problems/maximal-rectangle/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0)
            return 0;
        int max=0;
        int heights[]=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0'){
                    heights[j]=0;
                }
                else
                    heights[j]+=Character.getNumericValue(matrix[i][j]);
            }
            max=Math.max(max,largestRectangleArea(heights));
        }
        return max;
    } 
    
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