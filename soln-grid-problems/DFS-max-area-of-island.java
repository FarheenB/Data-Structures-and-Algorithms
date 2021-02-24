/*
https://leetcode.com/problems/max-area-of-island/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    int area;
    public int maxAreaOfIsland(int[][] grid) {
        int max_area=Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                area=0;
                if(grid[i][j]==1)
                    areaIsland(grid,i,j);
                max_area=Math.max(max_area,area);
            }
        }
       return max_area;
    }    
    
    public void areaIsland(int[][] grid,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]==0)
            return;
                                                   
        grid[i][j]=0;
        area++;
        areaIsland(grid,i+1,j);
        areaIsland(grid,i-1,j);
        areaIsland(grid,i,j+1);
        areaIsland(grid,i,j-1);      
    }
}