/*
 @author Farheen Bano

 References- 
 https://www.geeksforgeeks.org/coin-change-dp-7/
 https://leetcode.com/problems/coin-change/
 
 NOTE: Variation of Unbounded Knapsack Problem
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
  public int coinChange(int[] coins, int amount) {
        return minUnboundedSubsetSum(amount,coins);
    }
    
    public int minUnboundedSubsetSum(int amount, int[] coins){
        int dp[][]=new int[coins.length+1][amount+1];
        
        //first row initialization
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=Integer.MAX_VALUE-1;
        }
        
        //second row initialization
        for(int j=1;j<dp[0].length;j++){
            if(j%coins[0]==0)
                dp[1][j]=j/coins[0];
            else
                dp[1][j]=Integer.MAX_VALUE-1;
        }
    
        for(int i=2;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(coins[i-1]<=j){
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount]>amount?-1:dp[coins.length][amount];
    }
}
