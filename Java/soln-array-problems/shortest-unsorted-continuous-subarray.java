/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/shortest-unsorted-continuous-subarray
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            //Decreasing value
            if(nums[i]<nums[i-1])
                min=Math.min(min,nums[i]);
        }
        for(int i=nums.length-2;i>=0;i--){
            //Increasing value
            if(nums[i]>nums[i+1])
                max=Math.max(max,nums[i]);
        }
        
        int i,j;
        for(i=0;i<nums.length;i++){
            if(min<nums[i])
                break;
        }
        for(j=nums.length-1;j>=0;j--){
            if(max>nums[j])
                break;
        }
        return j-i<0?0:j-i+1;
    }
}