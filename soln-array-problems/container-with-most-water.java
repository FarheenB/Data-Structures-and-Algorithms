/*
https://www.interviewbit.com/problems/container-with-most-water/
https://leetcode.com/problems/container-with-most-water/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int maxArea(int[] height) {
        int maxArea=0;
        int left=0,right=height.length-1;
        while(left<right){
            int h=Math.min(height[left],height[right]);
            int l=right-left;
            maxArea=Math.max(maxArea,l*h);

            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}