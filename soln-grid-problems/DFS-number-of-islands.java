/*
https://leetcode.com/problems/number-of-islands/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0)
            return 0;
        
        int numberIslands=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1')
                    numberIslands+=dfs(grid,i,j);                
            }
        }
        return numberIslands;        
    }
    
    int[][] dirs={{1,0},{0,1},{-1,0},{0,-1}};
    public int dfs(char[][] grid, int i, int j){        
        for(int dir[]:dirs){
            int dir_x=i+dir[0];
            int dir_y=j+dir[1];
            if(dir_x>=0 && dir_x<grid.length && dir_y>=0 && dir_y<grid[i].length && grid[dir_x][dir_y]!='0'){
                grid[dir_x][dir_y]='0';
                dfs(grid,dir_x,dir_y);         
            }
        }
        return 1;
    }
}