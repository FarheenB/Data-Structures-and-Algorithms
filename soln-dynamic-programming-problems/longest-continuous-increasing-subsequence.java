/*
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/longest-continuous-increasing-subsequence/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==1)
            return 1;
        
        int n=nums.length;
        int lis[] = new int[n]; 
        int max = 0; 

        Arrays.fill(lis,1);
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                lis[i]=1+lis[i-1];
            }
            max=Math.max(max,lis[i]);
        }
        return max;
    }
}
