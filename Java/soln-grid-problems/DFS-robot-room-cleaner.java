/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/robot-room-cleaner/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    //      -1 (i)
    //       |
    // -1 -------- 1 (j)
    //       |
    //       1
    int[][] dirs = new int[][]{{-1, 0}, { 0, 1 }, { 1, 0 }, {0, -1}};
    Set<String> visited = new HashSet<>();    

    public void cleanRoom(Robot robot) {
        dfs(robot, 0, 0, 0);
    }

    private void goBack(Robot robot){
        // Backtracing phase. Regardless of current direction, move back one position
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
    
    // (x, y) is current position of robot, unvisited
    private void dfs(Robot robot, int x, int y, int dir) {
        visited.add(x + ":" + y);
        robot.clean();

        for (int i = 0; i < 4; i++) {
            int xx = x + dirs[dir][0];
            int yy = y + dirs[dir][1];

            if (!visited.contains(xx + ":" + yy) && robot.move()){
                dfs(robot, xx, yy, dir);
                goBack(robot);                  
            }
            // Turn next direction
            robot.turnRight();
            dir = (dir + 1) % 4;
        }
    }
}
