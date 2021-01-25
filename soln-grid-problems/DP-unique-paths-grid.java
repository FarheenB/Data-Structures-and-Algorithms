/*
https://www.interviewbit.com/problems/grid-unique-paths/
https://leetcode.com/problems/unique-paths/
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0)
            return 0;
        int[][] dp = new int[m][n];
        
        Arrays.fill(dp[0],1);
        for(int k = 0; k < m; k++)
            dp[k][0] = 1;
        
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1]; 
            }
        }
        return dp[m-1][n-1];
    }
}