/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/search-in-rotated-sorted-array
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int pos=minIndex(nums,0,n-1,n);
        if(target==nums[pos])
            return pos;
        else if(target>nums[pos] && target<=nums[n-1])
            return binarySearch(nums,pos+1,n-1,target);
        return binarySearch(nums,0,pos-1,target);
    }
    
    int minIndex(int[] arr, int start, int end, int n){
        int pos=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            int next=(mid+1)%n;
            int prev=(mid+n-1)%n;
            if(arr[mid]<=arr[prev] && arr[mid]<=arr[next]){
                return mid;
            }
            else if(arr[mid]<arr[end]){
                end=mid-1;
            }
            else
                start=mid+1;         
        }
        return pos;        
    }
    
    public int binarySearch(int[] nums, int start, int end, int target){ 
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(target==nums[mid])
                return mid;
            else if(target<nums[mid])
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }
}
