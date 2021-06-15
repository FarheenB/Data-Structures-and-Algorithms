/**
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 https://www.interviewbit.com/problems/subset-sum-problem/

 NOTE: Variation of 0/1 Knapsack
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public int isSubsetSum(int[] A, int B) {
        boolean[][] dp=new boolean[A.length+1][B+1];
        
        for(int i=0;i<dp.length;i++){
            dp[i][0]=true;
        }
        
        for(int j=1;j<dp.length;j++){
            dp[0][j]=false;
        }
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(A[i-1]<=j){
                    dp[i][j]=dp[i-1][j-A[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        
        return dp[A.length][B]?1:0;
    }
}
