/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
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
        int pos=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            int next=(mid+1)%n;
            int prev=(mid+n-1)%n;
            if(arr[mid]<=arr[prev] && arr[mid]<=arr[next]){
                return arr[mid];
            }
            else if(arr[mid]<arr[end]){
                end=mid-1;
            }
            else
                start=mid+1;         
        }
        return arr[pos];        
    }
}
