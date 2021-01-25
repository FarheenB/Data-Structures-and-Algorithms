/*
https://leetcode.com/problems/the-maze-ii

NOTE: The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
*/


public class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];
        
        //record distance of all the cell from source
        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        distance[start[0]][start[1]] = 0;
        
        dfs(maze, start[0], start[1], distance);
        
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    public void dfs(int[][] maze, int i, int j, int[][] distance) {
        //top, down,left,right directions
        int[][] dirs={{0,1}, {0,-1}, {-1,0}, {1,0}};
        for (int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            int count = 0;
            while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                //continue in one direction until hitting a wall
                x += dir[0];
                y += dir[1];
                count++;
            }
            if (distance[i][j] + count < distance[x - dir[0]][y - dir[1]]) {
                distance[x - dir[0]][y - dir[1]] = distance[i][j] + count;
                dfs(maze, x - dir[0],y - dir[1], distance);
            }
        }
    }
}