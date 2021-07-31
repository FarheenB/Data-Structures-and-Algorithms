/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/divide-chocolate/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<sweetness.length;i++){
            sum+=sweetness[i];
            min=Math.min(min,sweetness[i]);
        }
        int start=min;
        int end=sum;
        int result=-1;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isValid(sweetness,sweetness.length,k+1,mid)){
                result=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return result;            
    }
    
    public boolean isValid(int[] sweetness, int n, int k, int mid_max){
        int total=0;
        int friends=0;
        for(int i=0;i<n;i++){
            total+=sweetness[i];            
            if(total>=mid_max){
                total=0;
                friends++;
            }
        }
        return friends>=k;
    }
}
