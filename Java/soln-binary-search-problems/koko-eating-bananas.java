/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/koko-eating-bananas/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        if(piles.length==0)
            return 0;
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<piles.length;i++){
            min=Math.min(min,piles[i]);
        }
        int start=1;
        int end=max;
        int result=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isValid(piles,piles.length,H,mid)){
                result=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return result;
    }
    
    public boolean isValid(int[] piles, int n, int H, int mid_max){
        int hours=0;
        for(int i=0;i<n;i++){
            hours++;
            if(piles[i]>mid_max)
                hours+=piles[i]/mid_max;                      
        }        
        return hours<=H;
    }
}
