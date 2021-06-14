/*
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/partition-problem-dp-18/
 https://leetcode.com/problems/partition-equal-subset-sum/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    static int equalPartition(int N, int arr[]) {
        int sum=0;
        for(int i=0;i<arr.length;i++)
            sum+=arr[i];
        if(sum%2!=0){
            return -1;
        }
        return isSubsetSum(arr,N,sum/2)?1:-1 ;
    }

    public static boolean isSubsetSum(int arr[], int N, int sum) { 
        boolean [][]dp = new boolean [N+1][sum+1];
        
        for (int i = 0; i <= N; i++) 
            dp[i][0] = true; 
            
        for (int i = 1; i <= sum; i++) 
            dp[0][i] = false; 
            
        for (int i = 1; i <= N; i++) { 
            for (int j = 1; j <= sum; j++) { 
                if (arr[i - 1] <= j) 
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j]; 
                else
                    dp[i][j] = dp[i - 1][j]; 
            } 
        } 
  
        return dp[N][sum]; 
    } 
}
