/*
https://leetcode.com/problems/number-of-closed-islands/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int closedIsland(int[][] grid) {
        if(grid.length==0){
            return -1;
        }
        
        int row = grid.length;
        int col = grid[0].length;

        // top boundry row-first
        for(int c=0; c<col; c++){
            if(grid[0][c]==0)
                dfs(grid, 0, c);
        }

        // right boundry column-last
        for(int r=0; r<row; r++){
            if(grid[r][col-1]==0)
                 dfs(grid, r, col-1);
        }

        // bottom boundry row-last
        for(int c=0; c<col; c++){
            if(grid[row-1][c]==0)
                dfs(grid, row-1, c);
        }

        // left boundry column-first
        for(int r=0; r<row; r++){
            if(grid[r][0]==0)
                dfs(grid, r, 0);
        }
        
        int count=0;
         for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                if (grid[i][j]==0){
                    dfs(grid, i, j);
                    count++;
                }                    
            }
        }
        return count;
        
    }
    public void dfs(int[][] grid, int i, int j){
        if (i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 1)
            return;
        grid[i][j]=1;
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}