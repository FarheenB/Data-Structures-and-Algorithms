/*
https://leetcode.com/problems/find-k-th-smallest-pair-distance/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        int start=0;
        int end=nums[nums.length-1]-nums[0];
        int res=0;

        //binary search
        while(start<=end){
            int mid=start+(end-start)/2;            
            int count=0;
            int i=0;
            int j=0;
            
            while(j<nums.length){                
                while(nums[j]-nums[i]>mid)
                    i++;
                
                //number of pairs that can be formed with diff as equal or less than mid
                count+=j-i;  
                j++;
            }
            
            if(count>=k){
                res=mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }
        return res;      
    }
}