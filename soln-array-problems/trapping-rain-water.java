/*
https://leetcode.com/problems/trapping-rain-water/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int trap(int[] height) {
        if(height==null || height.length==0)
            return 0;
        
        int[] mxl=new int[height.length];        
        mxl[0]=height[0];
        for(int i=1;i<height.length;i++){
            mxl[i]=Math.max(mxl[i-1],height[i]);
        }
        
        int[] mxr=new int[height.length];
        mxr[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            mxr[i]=Math.max(mxr[i+1],height[i]);
        }
        
        int capacity=0;
        for(int i=0;i<height.length;i++){
            int minHeight=Math.min(mxl[i],mxr[i]);
            capacity+=Math.abs(minHeight-height[i]);
        }                    
        return capacity;        
    }
}