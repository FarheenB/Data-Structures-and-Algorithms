/*
https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
https://leetcode.com/problems/super-egg-drop/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	
	public static int solve(int e, int f, int dp[][]){
	    if(f==1 || f==0)
	        return f;
	    
	    if(e==1)
	        return f;
	    if(dp[e][f]!=-1)
	        return dp[e][f];
	    
	    int min=Integer.MAX_VALUE;
	    int low,high;
	    for(int k=1;k<=f;k++){
	        if(dp[e-1][k-1]!=-1)
	            low=dp[e-1][k-1];
	        else{
	            dp[e-1][k-1]=solve(e-1,k-1,dp);
	            low=dp[e-1][k-1];
	        }
            if(dp[e][f-k]!=-1)
	            high=dp[e][f-k];
	        else{
	            dp[e][f-k]=solve(e,f-k,dp);
	            high=dp[e][f-k];
	        }
	        int temp=1+Math.max(low,high);
	        min=Math.min(min,temp);
	    }
	    dp[e][f]=min;
	    return min;
	}
	
	//Driver method to test above method
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int T=sc.nextInt();
	    int e,f;
	    for(int i=1;i<=T;i++){
	        e=sc.nextInt();
	        f=sc.nextInt();
    		
    		int [][]t = new int [e+1][f+1]; 
  
            for (int[] row : t) 
                Arrays.fill(row, -1); 
    		
    		System.out.println(solve(e,f,t));
	    }	    
	}	
}