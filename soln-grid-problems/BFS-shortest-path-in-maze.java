/**
 @author Farheen Bano
 
 The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 
 Reference-
 https://leetcode.com/problems/the-maze-ii

 NOTE: BFS approach has an improved execution time over DFS approach for finding shortest path
*/

public class Solution {
    public class Coords{
        int x;
        int y;
        Coords(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];
        
        //record distance of all the cell from source
        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        distance[start[0]][start[1]] = 0;
        
        //top, down,left,right directions
        int[][] dirs={{0,1}, {0,-1}, {-1,0}, {1,0}};        
        
        Queue <Coords> queue = new LinkedList<> ();
        queue.add(new Coords(start[0],start[1]));

        while(!queue.isEmpty()){
            Coords s=queue.remove();
            
            for (int[] dir: dirs) {
                int x = s.x + dir[0];
                int y = s.y + dir[1];
                int count = 0;
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    //continue in one direction until hitting a wall
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                if (distance[s.x][s.y] + count < distance[x - dir[0]][y - dir[1]]) {
                    distance[x - dir[0]][y - dir[1]] = distance[s.x][s.y] + count;
                    queue.add(new Coords(x - dir[0],y - dir[1]));
                }
            }
        }
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }
}
