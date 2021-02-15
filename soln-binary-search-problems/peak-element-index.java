/*
https://practice.geeksforgeeks.org/problems/peak-element/1
https://leetcode.com/problems/find-peak-element/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int findPeakElement(int[] nums) {
        return binarySearch(nums,0,nums.length-1);
    }
    
    public int binarySearch(int[] nums, int start, int end){
        while (start < end) {
            int mid = start+(end-start) / 2;
            if (nums[mid] > nums[mid + 1])
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }
}