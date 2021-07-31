/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/unique-paths-iii/
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    int totalPaths = 0;
    
    public int uniquePathsIII(int[][] grid) {
        int totalZeros = 0;
        
        for (int i=0; i < grid.length; i++) {
            for (int j=0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) 
                    totalZeros++;
            }
        }
        
        for (int i=0; i < grid.length; i++) {
            for (int j=0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) 
                    dfs(grid, i, j, totalZeros);
            }
        }
        
        return totalPaths;
    }
    
    private void dfs(int[][] grid, int i, int j, int totalZeros) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1 || (grid[i][j] == 2 && totalZeros != 0)) 
            return;
        
        if (grid[i][j] == 2 && totalZeros == 0) {
            totalPaths++; 
            return;
        }
        
        if (grid[i][j] == 0) 
            totalZeros--;
        
        grid[i][j] = -1;
        
        dfs(grid, i + 1, j, totalZeros);
        dfs(grid, i - 1, j, totalZeros);
        dfs(grid, i, j + 1, totalZeros);
        dfs(grid, i, j - 1, totalZeros);
                
        grid[i][j] = 0;
    }   
}
