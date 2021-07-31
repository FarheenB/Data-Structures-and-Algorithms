/**
 @author Farheen Bano
  
 Reference-
 https://practice.geeksforgeeks.org/problems/index-of-first-1-in-a-sorted-array-of-0s-and-1s4048/1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Compute {
    public long firstIndex(long arr[], long n)
    {
        long result=binarySearchFirst(arr,0,arr.length-1,1);
        return result;
    }
    
    public long binarySearchFirst(long[] nums,int start, int end, long target){
        long pos=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                pos=mid;
                end=mid-1;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }                
        }
        return pos;
    }
}
