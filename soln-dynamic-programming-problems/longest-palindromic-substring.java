/*
https://www.geeksforgeeks.org/length-of-longest-palindrome-substring/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    
    public static String reverse(String s){
	    String reverse="";
	    for(int i=s.length()-1;i>=0;i--)
	        reverse+=s.charAt(i);
	    return reverse;
	} 
   
    public int longestCommonSubstring(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int max=0;
        int dp[][]=new int[m+1][n+1];

        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                    
                }

                else if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    max=Math.max(max,dp[i][j]);

                }
                else 
                    dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j]);

            }

        }
        
        return max;
    }
    
    public String longestPalindrome(String s) {
        return longestCommonSubstring(s,reverse(s));   
    }
}