/**
 @author Farheen Bano
  
 Reference-
 https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/

 NOTE: Variation of 0/1 Knapsack Problem
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static int numSubseq(int[] nums, int target) {
	return countSubsetSum(nums,target);
    } 
	
    public static int countSubsetSum(int[] A, int sum) {
        int[][] dp=new int[A.length+1][sum+1];
        
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }
        
        for(int j=1;j<dp[0].length;j++){
            dp[0][j]=0;
        }
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(A[i-1]<=j){
                    dp[i][j]=dp[i-1][j-A[i-1]]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        
        return dp[A.length][sum];
    }
}
