/*
https://leetcode.com/problems/arithmetic-slices/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<3)
            return 0;
        
        int[] dp=new int[A.length];
        int sum=0;
        
        for(int i=2;i<A.length;i++){
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                dp[i]=1+dp[i-1];
                sum+=dp[i];
            }
        }
        return sum;
    }
}