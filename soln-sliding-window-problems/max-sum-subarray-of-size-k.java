/**
 @author Farheen Bano
  
 Reference-
 https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    static int maximumSumSubarray(int k, ArrayList<Integer> nums,int N){
        int i=0;
        int j=0;
        int sum=0;
        int max=sum;
        while(j<nums.size()){
            sum+=nums.get(j);
            if((j-i+1)==k){
                max=Math.max(max,sum);
                sum-=nums.get(i);
                i++;
            }
            j++;    
        }
        return max;
    }
}
