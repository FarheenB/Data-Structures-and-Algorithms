/*
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/unique-paths-ii/
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        if(m == 0 || n == 0)
            return 0;
        
        if(obstacleGrid[0][0]==1)
            return 0;
        
        obstacleGrid[0][0]=1;
            
        for(int i=1;i<m;i++){
            obstacleGrid[i][0]= (obstacleGrid[i][0]==0 && obstacleGrid[i-1][0]==1) ? 1:0;
        }
        
        for(int j=1;j<n;j++){
            obstacleGrid[0][j]= (obstacleGrid[0][j]==0 && obstacleGrid[0][j-1]==1) ? 1:0;
        }
        
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j]==0 )
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1]; 
                else
                    obstacleGrid[i][j]=0;
            }
        }
        return obstacleGrid[m-1][n-1];
    }
}
