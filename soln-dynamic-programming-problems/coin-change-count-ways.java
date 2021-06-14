/*
 @author Farheen Bano

 Reference- 
 https://leetcode.com/problems/coin-change-2/

 NOTE: Variation of Unbounded Knapsack Problem
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int change(int amount, int[] coins) {
        return countUnboundedSubsetSum(amount,coins);
    }
    
    public int countUnboundedSubsetSum(int amount, int[] coins){
        int dp[][]=new int[coins.length+1][amount+1];
        
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }
        
        for(int j=1;j<dp[0].length;j++){
            dp[0][j]=0;
        }
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(coins[i-1]<=j){
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
