/*
https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int shipWithinDays(int[] weights, int D) {
       if(weights.length<D)
            return -1;
        int sum=0;
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<weights.length;i++){
            max=Math.max(max,weights[i]);
            sum+=weights[i];
        }
        int start=max;
        int end=sum;
        int result=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            
            if(isValid(weights,weights.length,D,mid)){
                result=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return result;
    }
    
    public boolean isValid(int[] weights, int n, int D, int mid_max){
        int days=1;
        int sum=0;
        for(int i=0;i<n;i++){
            
            if(sum+weights[i]>mid_max){
                days++;
                sum=0;
            }
            if(days>D)
                return false;
            sum+=weights[i];    
        }

        return true;
    }
}