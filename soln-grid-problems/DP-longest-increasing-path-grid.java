/*
https://www.geeksforgeeks.org/longest-increasing-path-matrix/
https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {

    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) 
            return 0;
        m = matrix.length; 
        n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                ans = Math.max(ans, dfs(matrix, i, j, dp));
        return ans;
    }

    public int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) 
            return dp[i][j];
        
        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];
            
            if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j])
                dp[i][j] = Math.max(dp[i][j], dfs(matrix, x, y, dp));
        }

        return ++dp[i][j];
    }
}