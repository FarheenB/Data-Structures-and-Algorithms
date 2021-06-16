/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/single-element-in-a-sorted-array/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==0)
            return -1;
        if(nums.length==1)
            return nums[0];
        return binarySearch(nums,0,nums.length-1);
    }
    
    public int binarySearch(int[] nums, int start, int end){ 
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(start==end)
                return nums[mid];
            if(mid%2==0){
                if(nums[mid]==nums[mid+1]){
                    start=mid+2;
                }
                else{
                    end=mid;
                }
            }
            else{
                if(nums[mid]==nums[mid-1]){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
            
        }
        return -1;
    }
}
