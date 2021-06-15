/**
 @author Farheen Bano
 
 0/1 Knapsack Problem - Given items of certain weights/values and maximum allowed weight
 how to pick items to pick items from this set to maximize sum of value of items such that
 sum of weights is less than or equal to maximum allowed weight.
 
 Time complexity - O(W*total items)
 
 Reference-
 https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {    
    public static int solve(int N, int W, int []wt, int[] val) { 
        int dp[][] = new int [N+1][W+1]; 
        for (int i = 0; i <= N; i++) { 
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) 
                    dp[i][j] = 0; 
                else if (wt[i - 1] <= j) 
                    dp[i][j] = Math.max(val[i-1]+dp[i - 1][j - wt[i - 1]], dp[i - 1][j]); 
                else
                    dp[i][j] = dp[i - 1][j]; 
            } 
        }          
        return dp[N][W]; 
    } 

    //Driver method to test above method
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int N,W;
        for(int m=1;m<=T;m++){
            N=sc.nextInt();
            W=sc.nextInt();
            
            int wt[]=new int[N];
            int v[]=new int[N];
            for(int i=0;i<N;i++){
                v[i]=sc.nextInt();
            }
            for(int i=0;i<N;i++){
                wt[i]=sc.nextInt();
            }
            System.out.println(solve(N,W,wt,v));
        }        
    }     
}
