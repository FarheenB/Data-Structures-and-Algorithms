/*
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/house-robber-ii/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {   
    public int rob(int[] nums) {
        if(nums==null)
            return 0;
        if(nums.length<3){
            return nums.length==0?0:nums.length==1?nums[0]:Math.max(nums[0],nums[1]);
        }
                
        //starting from 1st house and skipping last house as 1st and last house are adjacent
        int dp1[]=new int[nums.length];

        dp1[0]=nums[0];
        dp1[1] = Math.max(nums[0], nums[1]); 
        for(int i=2;i<nums.length-1;i++){
            dp1[i] = Math.max(dp1[i-2] + nums[i], dp1[i-1]);
        }
        
        //starting from 2nd house and checking till last house
        int dp2[]=new int[nums.length];

        dp2[0]=nums[0];
        dp2[1]=nums[1];
        dp2[2] = Math.max(nums[1], nums[2]); 
        for(int i=3;i<nums.length;i++){
            dp2[i] = Math.max(dp2[i-2] + nums[i], dp2[i-1]);
        }
        
        return Math.max(dp2[dp2.length-1],dp1[dp1.length-2]);
    }   
}
