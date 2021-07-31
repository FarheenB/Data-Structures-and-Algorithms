/**
 @author Farheen Bano
  
 Reference-
 https://practice.geeksforgeeks.org/problems/the-painters-partition-problem/0#
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int paintersPartition(int[] boards, int k) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<boards.length;i++){
            max=Math.max(max,boards[i]);
            sum+=boards[i];
        }
        int start=max;
        int end=sum;
        int result=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isValid(boards,boards.length,k,mid)){
                result=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return result;
    }
    
    public boolean isValid(int[] boards, int n, int k, int mid_max){
        int painters=1;
        int sum=0;
        for(int i=0;i<n;i++){
            
            if(sum+boards[i]>mid_max){
                painters++;
                sum=0;
            }
            if(painters>k)
                return false;
            sum+=boards[i]; 
        }
        return true;
    }
}
