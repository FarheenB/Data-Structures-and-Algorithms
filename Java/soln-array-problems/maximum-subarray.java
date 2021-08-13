/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/maximum-subarray/
 Kadane's Algorithm
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int maxSubArray(int[] a) {
        int size=a.length;
        int max_sum = Integer.MIN_VALUE;
        int cur_sum = 0; 
  
        for (int i = 0; i < size; i++){ 
            cur_sum=Math.max(a[i],cur_sum+a[i]);  
            max_sum=Math.max(max_sum, cur_sum); 
            
        }     
        return max_sum;    
    }
}