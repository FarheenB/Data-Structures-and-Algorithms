/**
 @author Farheen Bano
  
 References-
 https://www.interviewbit.com/problems/longest-increasing-subsequence
 https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 https://leetcode.com/problems/longest-increasing-subsequence/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int lis[] = new int[n]; 
        int max = 1; 

        Arrays.fill(lis,1);

        for(int j=1;j<nums.length;j++){
            for(int i=0;i<j;i++){
                if(nums[j]>nums[i])
                    lis[j]=Math.max(lis[j],1+lis[i]);
                max=Math.max(max,lis[j]);
            }
        }
        return max;
    }
}
