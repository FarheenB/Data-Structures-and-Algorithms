/**
 @author Farheen Bano

 Date 24-07-2021
  
 Reference-
 https://leetcode.com/problems/max-area-of-island/
*/

class Solution {
public:

    int area;
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int max_area=INT_MIN;
        for(int i=0;i<grid.size();i++)
        {
            for(int j=0;j<grid[i].size();j++){
                area=0;
                if(grid[i][j]==1){
                    areaIsland(grid,i,j);
                }
                max_area=max(max_area,area);
            }
        }
       return max_area;
    }    
    
    void areaIsland(vector<vector<int>>& grid,int i,int j){
        if(i<0 || i>=grid.size() || j<0 || j>=grid[i].size() || grid[i][j]==0)
            return;
                                                   
        grid[i][j]=0;
        area++;
        areaIsland(grid,i+1,j);
        areaIsland(grid,i-1,j);
        areaIsland(grid,i,j+1);
        areaIsland(grid,i,j-1);      
    }
};