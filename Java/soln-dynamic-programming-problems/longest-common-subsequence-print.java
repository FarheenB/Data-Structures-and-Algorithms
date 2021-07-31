/**
 @author Farheen Bano
  
 Reference-
 https://www.geeksforgeeks.org/printing-longest-common-subsequence/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static int[][] longestCommonSubsequence(String text1, String text2) {
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
        return dp;
    }
    
    public static String printLCS(String text1,String text2){
        int[][] dp=longestCommonSubsequence(text1,text2);
        
        int n=text1.length();
        int m=text2.length();
        char[] str1=text1.toCharArray();
        char[] str2=text2.toCharArray();
        
        StringBuilder subsequence=new StringBuilder();  
        int i=n;
        int j=m;
        
        while (i > 0 && j > 0) {
            if (str1[i-1]==str2[j-1]) { 
                subsequence.append(str1[i-1]);
                i--;  
                j--;   
            } 
            else if (dp[i][j-1] > dp[i-1][j]) 
                j--; 
            else
                i--;  
        }
        return subsequence.reverse().toString();
    }
    
    //Driver method to test the above method
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String a= sc.next();
        String b= sc.next();
        System.out.println(printLCS(a,b));            
    }
}
