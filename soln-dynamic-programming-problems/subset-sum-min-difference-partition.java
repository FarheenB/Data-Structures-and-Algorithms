/*
https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
https://www.interviewbit.com/problems/minimum-difference-subsets/

NOTE: Variation of 0/1 Knapsack
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public int solve(int[] A) {
        int sum=0;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
        }
        
        boolean[] sum_arr=countSubsetSum(A,sum);
        int diff=Integer.MAX_VALUE;
        for(int i=sum/2;i>=0;i--){
            if(sum_arr[i]){
                diff=Math.min(diff,sum-(2*i));
            }
        }
        return diff;
    }
    public boolean[] isSubsetSum(int[] A, int B) {
        boolean[][] dp=new boolean[A.length+1][B+1];
        
        for(int i=0;i<dp.length;i++){
            dp[i][0]=true;
        }
        
        for(int j=1;j<dp.length;j++){
            dp[0][j]=false;
        }
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(A[i-1]<=j){
                    dp[i][j]=dp[i-1][j-A[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        
        return dp[A.length-1];
    }
}
