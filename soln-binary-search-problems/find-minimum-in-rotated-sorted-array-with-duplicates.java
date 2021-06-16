/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        if(n==1 || nums[0]<nums[n-1])
            return nums[0];
        return binarySearch(nums,0,n-1,n);
    }
    
    int binarySearch(int[] arr, int start, int end, int n){
        while(start<=end){
            int mid=start+(end-start)/2;
            //unsorted section
            if(arr[mid]>arr[end]){
                start=mid+1;
            }
            //sorted section
            else if(arr[mid]<arr[end]){
                end=mid;
            }
            else
                end--;            
        }
        return arr[start];
        
    }
}
