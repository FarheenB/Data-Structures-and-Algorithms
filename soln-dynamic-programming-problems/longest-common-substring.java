/**
 @author Farheen Bano
  
 Reference-
 https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        char[] str1=S1.toCharArray();
        char[] str2=S2.toCharArray();
        
        int dp[][]=new int[n+1][m+1];
        int max=0;
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
                else if(str1[i-1]==str2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                    max=Math.max(max,dp[i][j]);
                }
                else
                    dp[i][j]=0;
            }
        }
        return max;
    }
}
