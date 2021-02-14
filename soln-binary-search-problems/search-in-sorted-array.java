/*
https://leetcode.com/problems/binary-search/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
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