/**
 @author Farheen Bano
  
 Reference-
 https://www.geeksforgeeks.org/min-cost-path-dp-6/
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class MinimumCostPath {
    public int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }
    
    private static int minCost(int cost[][], int m, int n) {
        int i, j;
        int dp[][]=new int[m+1][n+1];

        dp[0][0] = cost[0][0];

        for (i = 1; i <= m; i++)
            dp[i][0] = dp[i-1][0] + cost[i][0];

        for (j = 1; j <= n; j++)
            dp[0][j] = dp[0][j-1] + cost[0][j];

        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
                dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + cost[i][j];

        return dp[m][n];
    }

    /* Driver method to test above functions */
    public static void main(String args[]) {
        int cost[][]= {{1, 2, 3},
                    {4, 8, 2},
                    {1, 5, 3}};
        System.out.println(minCost(cost,2,2));
    }
}
