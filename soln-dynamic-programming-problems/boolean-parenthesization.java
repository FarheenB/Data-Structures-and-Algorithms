/*
https://www.geeksforgeeks.org/boolean-parenthesization-problem-dp-37/

NOTE: Variation of Matrix Chain Multiplicaton Problem
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{    
    static int countWays(int N, String S){
        int dp[][][]=new int[N+1][N+1][2];
        
        for(int row[][]:dp)
            for(int col[]:row)
                Arrays.fill(col,-1);
            
        return solve(S,0,N-1,1, dp);
    }
    
    static int solve(String str, int i, int j, int isTrue, int[][][] dp){
        if(i>j)
            return 0;
            
        if(i==j){
            if(isTrue==1){
                return (str.charAt(i)=='T')?1:0;
            }
            else{
                return (str.charAt(i)=='F')?1:0;
            }            
        }
        
        if(dp[i][j][isTrue]!=-1)
            return dp[i][j][isTrue];
            
        int temp_ans=0;
        
        int leftTrue, rightTrue, leftFalse, rightFalse;
        
        for(int k=i+1;k<=j-1;k=k+2){
            
            if(dp[i][k-1][1]!=-1)
                leftTrue= dp[i][k-1][1];
            else{
                //Count number of True in left Partition 
                leftTrue=solve(str,i,k-1,1,dp);
            }
            if(dp[i][k-1][0]!=-1)
                leftFalse=dp[i][k-1][0];
            else{
                //Count number of False in left Partition
                leftFalse=solve(str,i,k-1,0,dp);
            }
            if(dp[k+1][j][1]!=-1)
                rightTrue=dp[k+1][j][1];
            else{
                //Count number of True in right Partition
                rightTrue=solve(str,k+1,j,1,dp);
            }
            if(dp[k+1][j][0]!=-1)
                rightFalse=dp[k+1][j][0];
            else{
                //Count number of False in right Partition
                rightFalse=solve(str,k+1,j,0,dp);
            }

            //Evaluate AND operation
            if(str.charAt(k)=='&'){
                if(isTrue==1){
                    temp_ans=temp_ans+leftTrue*rightTrue;
                }
                else{
                    temp_ans=temp_ans+leftTrue*rightFalse+leftFalse*rightTrue+leftFalse*rightFalse;
                }
            }
            //Evaluate OR operation
            else if(str.charAt(k)=='|'){
                if(isTrue==1){
                    temp_ans=temp_ans+leftTrue*rightTrue+leftTrue*rightFalse+leftFalse*rightTrue;
                }
                else{
                    temp_ans=temp_ans+leftFalse*rightFalse;
                }
            }
            //Evaluate XOR operation
            else if(str.charAt(k)=='^'){
                if(isTrue==1){
                    temp_ans=temp_ans+leftTrue*rightFalse+leftFalse*rightTrue;
                }
                else{
                    temp_ans=temp_ans+leftTrue*rightTrue+leftFalse*rightFalse;
                }
            }
            dp[i][j][isTrue]=temp_ans;
        }
        return temp_ans;
    } 
}