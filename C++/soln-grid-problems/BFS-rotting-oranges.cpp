/**
 @author Farheen Bano

 Date 24-07-2021  
  
 Reference-
 https://leetcode.com/problems/rotting-oranges/
*/

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        queue<pair<int,int>> que;
        int r=grid.size();
        int c=grid[0].size();
        int fresh=0;
        int time=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==2){
                    que.push({i,j});
                }
                else if(grid[i][j]==1)
                    fresh++;
            }
        }
    
    //directions
    vector<vector<int>> dirs={{1,0},{0,1},{-1,0},{0,-1}};
    
    while(!que.empty()){
        int s=que.size();
        for(int i=0;i<s;i++){
            int x=que.front().first;
            int y=que.front().second;
            que.pop();
            for(auto dir:dirs){
                int dir_x=x+dir[0];
                int dir_y=y+dir[1];
                if(dir_x>=0 && dir_y>=0 && dir_x<r && dir_y<c && grid[dir_x][dir_y]==1){
                    grid[dir_x][dir_y]=2;
                    fresh--;
                    que.push({dir_x,dir_y});
                    
                }
            }
        }
        if(!que.empty())
            time++;
    }
    return fresh!=0?-1:time;    
    }
};