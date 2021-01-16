/*
https://leetcode.com/problems/unique-paths-iii/
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    int ans = 0;
    int totalzeroes = 1;
    
    public int uniquePathsIII(int[][] grid) {
        int row = -1;
        int col = -1;
        for(int i = 0; i < grid.length; i++){
            for(int j =0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    row = i;
                    col = j;
                }else if(grid[i][j] == 0){
                    totalzeroes++;
                }
            }
        }
        
        dfs(grid, row, col);
        return ans;
    }
    
    public void dfs(int [][]grid, int i, int j){
        
        if(i < 0 || j <0 || i >= grid.length || j >= grid[0].length || grid[i][j] < 0)
            return;
        
        if(grid[i][j] == 2){
            if(totalzeroes == 0)
            ans += 1;
            return;
        }
        
        grid[i][j] = -2;
        totalzeroes--;

        dfs(grid, i+1,j);
        dfs(grid, i-1,j);
        dfs(grid, i,j+1);
        dfs(grid, i,j-1);

        grid[i][j] = 0;
        totalzeroes++;
    }
}