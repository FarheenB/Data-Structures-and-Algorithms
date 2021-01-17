/*
https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
https://leetcode.com/problems/maximum-subarray/

NOTE: Kadane's Algorithm
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int maxSubArray(int[] a) {
        int size=a.length;
        int max_so_far = Integer.MIN_VALUE, 
        max_ending_here = 0,start = 0, end = 0, s = 0; 
  
        for (int i = 0; i < size; i++)  
        { 
            max_ending_here += a[i]; 
            if (max_ending_here < 0)  
            { 
                max_ending_here = 0; 
                s = i + 1; 
            } 
  
            if (max_so_far < max_ending_here)  
            { 
                max_so_far = max_ending_here; 
                start = s; 
                end = i; 
            } 
  

        }     
        return max_so_far;
    }
}