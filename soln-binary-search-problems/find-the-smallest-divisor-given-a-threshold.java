/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        
        //first range from 1 to max
        int start=1;
        int end=max;
        int result=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            
            if(isValid(nums,nums.length,threshold,mid)){
                result=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return result;
    }
    
    public boolean isValid(int[] nums, int n, int threshold, int mid_max){
        int divisor=0;
        for(int i=0;i<n;i++){
            //sum of all divisors
            divisor+=(int)Math.ceil((nums[i]*1.0)/(mid_max*1.0));    
        }
        return divisor<=threshold;
    }
}
