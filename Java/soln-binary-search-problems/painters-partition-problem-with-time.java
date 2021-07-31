/**
 @author Farheen Bano
  
 Reference-
 https://www.interviewbit.com/problems/painters-partition-problem/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public int paint(int k, int time, int[] boards) {
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
            long mid=(long)start+((long)end-start)/2;
            if(isValid(boards,boards.length,k,(int)mid)){
                result=(int)mid;
                end=(int)mid-1;
            }
            else{
                start=(int)mid+1;
            }
        }
        return (int)(((long)result*time)%10000003);
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
