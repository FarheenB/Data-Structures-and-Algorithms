/*
https://www.geeksforgeeks.org/longest-common-substring-dp-29/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

	public static int longestCommonSubstring(String text1, String text2, int m, int n){
        int dp[][]=new int[m+1][n+1];
        int result = 0;
        
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;                    
                }

                else if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    result=Math.max(result,dp[i][j]);
                }

                else 
                    dp[i][j]=0;
            }
        }
        return result;
    }

    //Driver method to test the above method
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int queries=sc.nextInt();

        for(int i=1;i<=queries;i++){
            int m=sc.nextInt();
            int n=sc.nextInt();
            String a= sc.next();
            String b= sc.next();
            System.out.println(longestCommonSubstring(a,b,m,n));            
        }
    }
}