/*
https://leetcode.com/problems/3sum-closest/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min_diff=Integer.MAX_VALUE;
        int result_sum=0;
        Arrays.sort(nums);       
        
        for(int k=0;k<nums.length-2;k++){
            int i=k+1;
            int j=nums.length-1;           
            while(i<j){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==target)
                    return sum;
                else if(sum<target)
                    i++;
                else
                    j--;
                
                int diff=Math.abs(sum-target);
                if(min_diff>diff){
                    min_diff=diff;
                    result_sum=sum;                    
                }                   
            }
        }
        return result_sum;        
    }
} 