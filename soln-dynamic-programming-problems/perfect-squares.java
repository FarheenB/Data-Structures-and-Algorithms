/*
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/perfect-squares/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int numSquares(int n) {
        if(n==0)
            return 0;
        
        int root=(int)Math.sqrt(n);
        if(root*root==n)
            return 1;

        if(n<=3)
            return n;
        
        int[] dp=new int[n+1];
        
        for(int i=0;i<=n;i++){
            dp[i]=i;
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
