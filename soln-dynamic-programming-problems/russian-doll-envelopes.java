/*
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/russian-doll-envelopes/

 NOTE: Variation of Longest Increasing Subsequence
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null || envelopes.length==0)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {            
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } 
                else {
                    return arr1[0] - arr2[0];
                }
           }
        });
        
        int height[]=new int[envelopes.length];
        for(int i=0;i<envelopes.length;i++){
            height[i]=envelopes[i][1];
        }
        return lengthOfLIS(height);
    }
    
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int lis[] = new int[n]; 
        int max = 1; 

        Arrays.fill(lis,1);

        for(int j=1;j<nums.length;j++){
            for(int i=0;i<j;i++){
                if(nums[j]>nums[i])
                    lis[j]=Math.max(lis[j],1+lis[i]);
                max=Math.max(max,lis[j]);
            }
        }
        return max;
    }
}
