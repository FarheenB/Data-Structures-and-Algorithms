/**
 @author Farheen Bano
  
 Reference-
 https://www.geeksforgeeks.org/print-longest-common-substring/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static String printLongestCommonSubstring(String text1, String text2){
        int n=text1.length();
        int m=text2.length();
        char[] str1=text1.toCharArray();
        char[] str2=text2.toCharArray();
        
        int dp[][]=new int[n+1][m+1];
        int max=0;
        int end=-1;
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
                else if(str1[i-1]==str2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                    if(dp[i][j]>max){
                        max=dp[i][j];
                        end=i-1;     
                    }
                }
                else 
                    dp[i][j]=0;
            }
        }
        return text1.substring(end-max+1,end+1);
    }

    //Driver method to test the above method
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String a= sc.next();
        String b= sc.next();
        System.out.println(printLongestCommonSubstring(a,b));
    }
}
