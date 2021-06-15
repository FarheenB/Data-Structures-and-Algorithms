/*
 @author Farheen Bano
  
 References-
 https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1
 https://leetcode.com/problems/first-missing-positive/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums==null || nums.length==0)
            return 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0 || nums[i]>nums.length)
                continue;
            if(nums[i]!=(i+1)){
                int x=nums[i]-1;
                if(nums[x]==x+1)
                    continue;
                else{
                    int temp=nums[x];
                    nums[x]=nums[i];
                    nums[i]=temp; 
                    i--;
                }
            }
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        return nums.length+1;
    }
}
