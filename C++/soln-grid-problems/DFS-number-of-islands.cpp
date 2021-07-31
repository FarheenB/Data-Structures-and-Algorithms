/**
 @author Farheen Bano

 Date 24-07-2021

 Reference-
 https://leetcode.com/problems/number-of-islands/
*/

class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int islandCount=0;
        
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid[0].size();j++){
                if(grid[i][j]=='1'){
                    islandCount+=dfs(grid,i,j);                    
                }
            }
        }
        return islandCount;
    }
    
    vector<vector<int>> dirs={{1,0},{0,1},{-1,0},{0,-1}};
    int dfs(vector<vector<char>>& grid,int i, int j){
        for(auto dir:dirs){
            int dir_x=i+dir[0];
            int dir_y=j+dir[1];
            
            if(dir_x>=0 && dir_y>=0 && dir_x<grid.size() && dir_y<grid[0].size() && grid[dir_x][dir_y]!='0'){
                grid[dir_x][dir_y]='0';
                dfs(grid,dir_x, dir_y);
            }

        }
        return 1;
    }
};