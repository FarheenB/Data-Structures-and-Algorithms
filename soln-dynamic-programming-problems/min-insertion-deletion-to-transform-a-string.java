/*
https://www.geeksforgeeks.org/minimum-number-deletions-insertions-transform-one-string-another/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    int m=str1.length();
	    int n=str2.length();
	    return (m-LCS(str1,str2,m,n))+(n-LCS(str1,str2,m,n));
	} 

	public static int LCS(String a, String b, int m, int n){
        int t[][]=new int[m+1][n+1];

        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0){
                    t[i][j]=0;
                    
                }

                else if(a.charAt(i-1)==b.charAt(j-1)){
                    t[i][j]=t[i-1][j-1]+1;

                }
                else 
                    t[i][j]=Math.max(t[i][j-1],t[i-1][j]);

            }

        }
        return t[m][n];
    }
}