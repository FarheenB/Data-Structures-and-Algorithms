/**
 @author Farheen Bano
  
 Reference-
 https://www.geeksforgeeks.org/ceiling-in-a-sorted-array/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class CeilSearch{
    
    // Function to find ceil of x
    // arr: input array
    // n is the size of array
    static int findCeil(long nums[], int n, long target)
    {
        if(n==0)
            return -1;
        if(target>nums[n-1])
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
        return start;
    }
}
