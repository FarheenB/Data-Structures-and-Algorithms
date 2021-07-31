/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int minOperations(int[] nums, int x) {
        int total=0;
        
        for(int n:nums)
            total+=n;

        int diff=total-x;   
        //since arrays contains only positive integers
        if(diff<0)
            return -1;

        int i=0;
        int j=0;
        int sum=0;
        int maxLen=Integer.MIN_VALUE;
        while(j<nums.length){
            sum+=nums[j];
            
            while(sum>diff && i<nums.length){
                sum-=nums[i];
                i++;
            }
            if(sum==diff)
                maxLen=Math.max(maxLen,j-i+1);
            j++;
        }        
        return maxLen==Integer.MIN_VALUE?-1:(nums.length-maxLen);        
    }
}
