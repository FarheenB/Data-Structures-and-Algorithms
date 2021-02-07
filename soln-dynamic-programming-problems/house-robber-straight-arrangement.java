/*
https://leetcode.com/problems/house-robber/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int rob(int[] nums) {
        if(nums==null)
            return 0;
        if(nums.length<2){
            return nums.length==0?0:nums[0];
        }
        
        int dp[]=new int[nums.length];
        dp[0]=nums[0];
        dp[1] = Math.max(nums[0], dp[1]); 

        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[dp.length-1];
    }
}