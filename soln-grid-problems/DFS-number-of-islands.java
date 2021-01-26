/*
https://leetcode.com/problems/number-of-islands/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        
        int numberIslands=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    numberIslands+=dfs(grid,i,j);
                }
            }
        }
        return numberIslands;
        
    }
    
    public int dfs(char[][] grid, int i, int j){
        if(i<0||i>=grid.length || j<0 ||j>=grid[i].length ||grid[i][j]=='0'){
            return 0;
        }
        grid[i][j]='0';
        
        dfs(grid, i-1,j);
        dfs(grid, i,j-1);
        dfs(grid, i+1,j);
        dfs(grid, i,j+1);
        return 1;
    }
}