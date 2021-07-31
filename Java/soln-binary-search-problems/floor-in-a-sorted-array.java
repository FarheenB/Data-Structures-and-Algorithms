/**
 @author Farheen Bano
  
 Reference-
 https://practice.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class FloorSearch{
    
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long nums[], int n, long target)
    {
        if(n==0)
            return -1;
        if(target<nums[0])
            return -1;
        return binarySearch(nums,0,nums.length-1,target);
    }
    
    public static int binarySearch(long[] nums, int start, int end, long target){ 
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
        return end;
    }
}
