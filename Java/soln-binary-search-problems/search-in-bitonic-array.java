/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/find-in-mountain-array/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak_pos=binarySearchPeak(mountainArr,0,mountainArr.length()-1);

        if(target==mountainArr.get(peak_pos))
            return peak_pos;
        //binary search on left half of array
        int pos=binarySearch(mountainArr,0,peak_pos-1,target,true);
        if(pos>=0)
            return pos;
        //binary search on right half of array
        return binarySearch(mountainArr,peak_pos+1,mountainArr.length()-1,target,false);        
    }
    
    public int binarySearchPeak(MountainArray mountainArr, int start, int end){
        while (start < end) {
            int mid = start+(end-start) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid+1))
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }
    
    public int binarySearch(MountainArray mountainArr, int start, int end, int target, boolean asc){
        while(start<=end){
            int mid=start+(end-start)/2;
            int midEle=mountainArr.get(mid);
            if(midEle==target)
                return mid;
            //for left half of array
            if(asc){
                if(midEle>target)
                    end=mid-1;
                else
                    start=mid+1;
            }
            //for right half of array
            else{
                if(midEle<target)
                    end=mid-1;
                else
                    start=mid+1;
            }         
        }
        return -1;
    }
}
