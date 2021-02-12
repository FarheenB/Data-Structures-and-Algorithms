/*
https://leetcode.com/problems/delete-operation-for-two-strings/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int minDistance(String word1, String word2) {
	    int n=word1.length();
        int m=word2.length();
        int subsequence=longestCommonSubsequence(word1,word2);
        return (n-subsequence)+(m-subsequence);
    } 
    
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        char[] str1=text1.toCharArray();
        char[] str2=text2.toCharArray();
        
        int dp[][]=new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
                else if(str1[i-1]==str2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else 
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[n][m];
    }
}