/**
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/shortest-distance-two-cells-matrix-grid/
 https://leetcode.com/problems/shortest-path-in-binary-matrix/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Coords{
    int x;
    int y;
    
    Coords(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1 || grid[grid.length-1][grid[0].length-1]==1)
            return -1;
        
        bfs(grid,0,0);
        int dest=grid[grid.length-1][grid[0].length-1];
        return dest==0?-1:dest;
    }
    
    int[][] dirs={{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
    
    public void bfs(int[][] grid, int i, int j){    
        Queue<Coords> queue=new LinkedList<>();
        queue.add(new Coords(i,j));
        int dist=1;
        grid[i][j]+=dist;

        while(!queue.isEmpty()){
            int size=queue.size();
            dist++;
            for(int k=0;k<size;k++){
                Coords cell=queue.poll();
                    
                for(int[] dir:dirs){
                    int dir_x=cell.x+dir[0];
                    int dir_y=cell.y+dir[1];
                    
                    if(dir_x>=0 && dir_x<grid.length && dir_y>=0 && dir_y<grid.length && grid[dir_x][dir_y]==0){
                        grid[dir_x][dir_y]=dist;
                        queue.add(new Coords(dir_x,dir_y));
                    }
                }
            }   
        }
    }
}
