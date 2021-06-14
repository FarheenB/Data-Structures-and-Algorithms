/*
 @author Farheen Bano
  
 Reference-
 https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1
*/

import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
    public static int longestPalindromeSubstr(String s) {
        String reverse_s=new StringBuilder(s).reverse().toString();
        int n=s.length();
        char[] str1=s.toCharArray();
        char[] str2=reverse_s.toCharArray();
        
        int dp[][]=new int[n+1][n+1];
        int max=0;
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
                else if(str1[i-1]==str2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];

                    int startIdx = i;
                    int lastIdx = j - dp[i][j] + 1;
                    
                    // Here we check if the reverse string original idx is same as original string idx.
                    if (n-startIdx+1 == lastIdx)                    
                        max=Math.max(max,dp[i][j]);     
                }
                else 
                    dp[i][j]=0;
            }
        }
        return max;
    }
}
