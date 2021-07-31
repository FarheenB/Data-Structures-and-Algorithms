  
/**
 @author Farheen Bano

 Date 24-07-2021
  
 Reference-
 https://leetcode.com/problems/unique-paths-iii/
*/

class Solution {
public:
    int totalPaths = 0;

    int uniquePathsIII(vector<vector<int>>& grid) {
        int totalZeros = 0;
        
        for (int i=0; i < grid.size(); i++) {
            for (int j=0; j < grid[0].size(); j++) {
                if (grid[i][j] == 0) 
                    totalZeros++;
            }
        }
        
        for (int i=0; i < grid.size(); i++) {
            for (int j=0; j < grid[0].size(); j++) {
                if (grid[i][j] == 1) 
                    dfs(grid, i, j, totalZeros);
            }
        }
        
        return totalPaths;
    }
    
    void dfs(vector<vector<int>>& grid, int i, int j, int totalZeros) {
        if (i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size() || grid[i][j] == -1 || (grid[i][j] == 2 && totalZeros != 0)) 
            return;
        
        if (grid[i][j] == 2 && totalZeros == 0) {
            totalPaths++; 
            return;
        }
        
        if (grid[i][j] == 0) 
            totalZeros--;
        
        grid[i][j] = -1;
        
        dfs(grid, i + 1, j, totalZeros);
        dfs(grid, i - 1, j, totalZeros);
        dfs(grid, i, j + 1, totalZeros);
        dfs(grid, i, j - 1, totalZeros);  
                
        grid[i][j] = 0;
    }
};