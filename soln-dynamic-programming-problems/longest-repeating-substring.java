/*
https://leetcode.com/problems/longest-repeating-substring
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int longestRepeatingSubstring(String S) {
         return modified_longestCommonSubstr(S,S);
    }
    
    public int modified_longestCommonSubstr(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        char[] str1=text1.toCharArray();
        char[] str2=text2.toCharArray();
        
        int dp[][]=new int[n+1][m+1];
        int max=0;
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
                else if(str1[i-1]==str2[j-1] && i!=j){
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