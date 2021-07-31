/**
 @author Farheen Bano

 Date 24-07-2021   
  
 References-
 https://www.geeksforgeeks.org/shortest-distance-two-cells-matrix-grid/
 https://leetcode.com/problems/shortest-path-in-binary-matrix/
*/

class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {      
        
        int r=grid.size();
        int c=grid[0].size();
        if(grid[0][0]==1 || grid[r-1][c-1]==1)
            return -1;
        queue<pair<int,int>> que;

        int dist=1;
          
        //direction
        vector<vector<int>> dirs={{1,0},{0,1},{-1,0},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
        que.push({0,0});
        grid[0][0]=dist;
        while(!que.empty()){
            int s=que.size();
            dist++;
            for(int i=0;i<s;i++){
                int x=que.front().first;
                int y=que.front().second;
                que.pop();

                for(auto dir:dirs){
                    int dir_x=x+dir[0];
                    int dir_y=y+dir[1];

                    if(dir_x>=0 && dir_y>=0 && dir_x<r && dir_y<c && grid[dir_x][dir_y]==0){
                        grid[dir_x][dir_y]=dist;

                        que.push({dir_x,dir_y});

                    }
                }
            }
        }
        return grid[r-1][c-1]==0?-1:grid[r-1][c-1];
    }
};