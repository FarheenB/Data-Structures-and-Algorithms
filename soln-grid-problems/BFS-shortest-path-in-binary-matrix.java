/*
https://www.geeksforgeeks.org/shortest-distance-two-cells-matrix-grid/
https://leetcode.com/problems/shortest-path-in-binary-matrix/
*/

class Solution {
    public class Coords{
        int x;
        int y;
        Coords(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        
        //check for blocker at the origin and destination 
        if(grid[0][0] == 1 || grid[N-1][N-1] == 1) 
            return -1;
        
        // right, bottom, left, top, top-left, top-right, bottom-left, bottom-right
        int dx[] = { 1, 0, -1, 0, -1, 1, -1, 1 };
        int dy[] = { 0, 1, 0, -1, -1, -1, 1, 1 };
                
        Queue<Coords> queue=new LinkedList<>();
        
        //Enqueue the first coordinate
        queue.add(new Coords(0, 0));
        grid[0][0] = 1;
        
        while(!queue.isEmpty()) {
            Coords s=queue.remove();
            int distance=grid[s.x][s.y];
            
            if(s.x == N-1 && s.y == N-1) 
                return distance;
            
            grid[s.x][s.y] = 1;
            
            for(int i = 0; i < 8; i++) {
                int x = s.x + dx[i];
                int y = s.y + dy[i];
                if(x < 0 || x >= N || y < 0 || y >= N || grid[x][y]!=0) 
                    continue;
                queue.add(new Coords(x,y));
                grid[x][y]=distance+1;
            }
        }
        return -1;
    }
}