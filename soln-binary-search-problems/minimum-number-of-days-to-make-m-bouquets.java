/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int minDays(int[] bloomday, int m, int k) {
        if(m==0)
            return 0;
       if(m*k>bloomday.length)
            return -1;
        int sum=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<bloomday.length;i++){
            max=Math.max(max,bloomday[i]);
            min=Math.min(min,bloomday[i]);

        }
        int start=min;
        int end=max;
        int result=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            
            if(isValid(bloomday,bloomday.length,m,k,mid)){
                result=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return result;
    }
    
    public boolean isValid(int[] bloomday, int n, int m, int k,int mid_max){
        int days=0;
        int count=0;
        for(int i=0;i<n;i++){
            if(bloomday[i]>mid_max){
                count=0;
            }
            else
                count++;
            if(count>=k){
                count=0;
                days++;
            }   
        }
        return days>=m;
    }
}
