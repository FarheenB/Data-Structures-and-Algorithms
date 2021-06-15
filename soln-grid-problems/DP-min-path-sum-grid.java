/**
 @author Farheen Bano
  
 References-
 https://leetcode.com/problems/minimum-path-sum/
 
 Note: You can only move either down or right at any point in time.
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    public int minPathSum(int[][] grid) {        
        int sum=grid[0][0];
        int dp[][]=new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];
        int down=0;
        int right=0;

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if((i-1)>=0 && (j-1)>=0) {
                    right=dp[i-1][j];
                    down=dp[i][j-1];
                    dp[i][j]=Math.min(down,right)+grid[i][j];
                    continue;
                }

                if((j-1)>=0 && (i-1)<0) {
                    down=dp[i][j-1];
                    dp[i][j]=down+grid[i][j];
                }
            
                else if((i-1)>=0 && (j-1)<0) {
                    right=dp[i-1][j];
                    dp[i][j]=right+grid[i][j];
                    continue;
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
