/*
https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
https://leetcode.com/problems/longest-increasing-subsequence/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int lis[] = new int[n]; 
        int i,j,max = 0; 

        for ( i = 0; i < n; i++ ) 
            lis[i] = 1; 

        for ( i = 1; i < n; i++ ) 
            for ( j = 0; j < i; j++ )  
                if ( nums[i] > nums[j])
                lis[i] = Math.max(lis[i],lis[j] + 1);

        for ( i = 0; i < n; i++ ) 
            if ( max < lis[i] ) 
                max = lis[i]; 

        return max; 
        
    }
}