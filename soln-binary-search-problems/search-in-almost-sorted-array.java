/**
 @author Farheen Bano
  
 Reference-
 https://www.geeksforgeeks.org/search-almost-sorted-array/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public int binarySearch(int[] nums, int start, int end, int target) { 
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(target==nums[mid])
                return mid;
            else if(mid-1>=start && target==nums[mid-1])
                return mid-1;
            else if(mid+1<=end && target==nums[mid+1])
                return mid+1;
            else if(target<nums[mid])
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }
}
