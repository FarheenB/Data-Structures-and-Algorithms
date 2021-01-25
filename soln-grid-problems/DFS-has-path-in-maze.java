/*
https://leetcode.com/problems/the-maze/
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
        int right = j + 1, left = j - 1, up  = i - 1, down = i + 1;
        
        while (right < maze[0].length && maze[i][right] == 0) // right movement
            right++;
        if (dfs(maze, i, right - 1, m,n, visited))
            return true;
        
        while (left >= 0 && maze[i][left] == 0) //left movement
            left--;
        if (dfs(maze, i, left + 1, m,n, visited))
            return true;
        
        while (up  >= 0 && maze[up][j] == 0) //up movement
            up--;
        if (dfs(maze, up  + 1, j, m,n, visited))
            return true;
        
        while (down < maze.length && maze[down][j] == 0) //down movement
            down++;
        if (dfs(maze, down - 1, j, m,n, visited))
            return true;
        
        return false;
    }
}