/*
https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

	public static int solve(int N, int price[], int length[]) 
    { 
        int dp[][]=new int[N+1][N+1];
        
        for(int i=0;i<=N;i++){
            for(int j=0;j<=N;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
                else if(length[i-1]<=j){
                    dp[i][j]=Math.max(price[i-1]+dp[i][j-length[i-1]], dp[i-1][j]);
                }
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[N][N];
    }

    //Driver method to test the above method
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int N;
        for(int m=1;m<=T;m++){
            N=sc.nextInt();
            int v[]=new int[N];
            int length[]=new int[N];
            for(int i=0;i<N;i++){
                v[i]=sc.nextInt();
                length[i]=i+1;
            }
            System.out.println(solve(N,v,length));
    
        }
    }
}