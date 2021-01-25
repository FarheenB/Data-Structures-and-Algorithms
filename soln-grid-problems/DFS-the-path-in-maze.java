/*
https://leetcode.com/problems/the-maze/

NOTE: The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.


*/

public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start[0],start[1], destination[0], destination[1], visited);
    }

    public boolean dfs(int[][] maze, int i, int j, int m, int n, boolean[][] visited) {
        if (visited[i][j])
            return false;
        
        if (i == m && j == n)
            return true;
        
        visited[i][j] = true;
        
        int[][] dirs={{0,1}, {0,-1}, {-1,0}, {1,0}};
        for (int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            int count = 0;
            while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
            }
            
            if (dfs(maze, x - dir[0],y - dir[1], m,n, visited))
                return true;
        }
        
        return false;
    }
}