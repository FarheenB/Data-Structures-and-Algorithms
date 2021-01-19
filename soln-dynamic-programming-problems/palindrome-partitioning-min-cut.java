/*
https://leetcode.com/problems/palindrome-partitioning-ii/

NOTE: Variation of Matrix Chain Multiplicaton Problem
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
public int minCut(String str) {
        int t[][]=new int[str.length()+1][str.length()+1];
    
        for(int[] l:t)
            Arrays.fill(l,-1);
    
        return solve(str,0,str.length()-1,t);
    }
   
    static int solve(String str, int i, int j, int t[][]){
        if(i>=j)
            return 0;
        
        if(isPalindrome(str,i,j))
            return 0;
        
        if(t[i][j]!=-1)
            return t[i][j];
        
        int min=Integer.MAX_VALUE;
        int left,right;
        for(int k=i;k<j;k++){
            if(t[i][k]!=-1)
                left= t[i][k];
            else
            {
                left=solve(str,i,k,t);
                t[i][j]=left;
            }
            
            if(t[k+1][j]!=-1)
                right=t[k+1][j];
            else
            {
                right=solve(str,k+1,j,t);
                t[k+1][j]=right;
            }
            
            int temp=1+left+right;
            min=Math.min(min,temp);
        }
        t[i][j]=min;
        return t[i][j];        
    }
    
    static boolean isPalindrome(String str, int i,int j){
        if(i==j)
            return true;
        if(i>j)
            return true;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
        
    }

}