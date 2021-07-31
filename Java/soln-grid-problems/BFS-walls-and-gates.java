/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/walls-and-gates/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Coords{
    int x;
    int y;
    public Coords(int x, int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    int dir[][]={{0,1},{1,0},{-1,0},{0,-1}};
    public void wallsAndGates(int[][] rooms) {
        Queue<Coords> queue=new LinkedList<>();
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j]==0){
                    queue.offer(new Coords(i,j));
                }
            }
        }
          
        while(!queue.isEmpty()){
            Coords cur_cell=queue.poll();

            for(int x=0;x<4;x++){
                int dx=cur_cell.x+dir[x][0];
                int dy=cur_cell.y+dir[x][1];

                if(dx<0 || dx>=rooms.length || dy<0 || dy>=rooms[0].length || rooms[dx][dy]!=Integer.MAX_VALUE){
                    continue;
                }
                rooms[dx][dy]=rooms[cur_cell.x][cur_cell.y]+1;
                queue.offer(new Coords(dx,dy));
              
            }
        }
    }    
}
