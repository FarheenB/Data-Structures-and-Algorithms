/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/detect-cycles-in-2d-grid
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    boolean isCyclic=false;
    boolean[][] visited;

    public boolean containsCycle(char[][] grid) {
        visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j]){
                    if(dfsCycleDetect(grid,i,j,grid[i][j],0))
                        return true;
                }
            }
        }
        return false;
    }
    
    //Directions- dummy:0, down:1,left:2,up:3,right:4    
    public boolean dfsCycleDetect(char[][] grid, int i, int j, char ch, int dir){         
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!=ch)
            return false;
        if(visited[i][j])
            return true;       

        visited[i][j]=true;
        return (dir!=1 && dfsCycleDetect(grid, i-1, j, ch, 3)) || 
               (dir!=2 && dfsCycleDetect(grid, i, j+1, ch, 4)) || 
               (dir!=3 && dfsCycleDetect(grid, i+1, j, ch , 1)) || 
               (dir!=4 && dfsCycleDetect(grid, i, j-1, ch, 2));              
    }
}
