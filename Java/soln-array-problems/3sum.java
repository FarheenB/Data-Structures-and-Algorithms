/**
 @author Farheen Bano
  
 References-
 https://www.interviewbit.com/problems/3-sum-zero/
 https://leetcode.com/problems/3sum/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets=new ArrayList<>();
        int n=nums.length;
        if(n<3)
            return triplets;
        Arrays.sort(nums);   
        
        for (int i=0; i<n-2; i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            
            int left=i+1;
            int right=n-1;            
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    triplets.add(Arrays.asList(nums[i],nums[left],nums[right])); 
                    
                    left++;
                    while(left<n && nums[left]==nums[left-1])
                        left++;
                }
                else if(sum<0)
                    left++;
                else
                    right--;
            }
        }  
        return triplets;    
    }
}