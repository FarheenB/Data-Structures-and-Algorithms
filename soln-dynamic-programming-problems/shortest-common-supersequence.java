/*
https://www.geeksforgeeks.org/shortest-common-supersequence/
*/ 

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	
	public static int ShortestCommonSubsequence(String text1, String text2, int m, int n){
	    return m+n-longestCommonSubsequence(text1,text2,m,n);
	    
	}
	
	public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();

        int dp[][]=new int[m+1][n+1];

        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                    
                }

                else if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;

                }
                else 
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);

            }

        }
        return dp[m][n];
    }
}
