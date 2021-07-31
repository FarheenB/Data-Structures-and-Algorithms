/**
 @author Farheen Bano
 
 Date 24-07-2021
  
 References-
 https://practice.geeksforgeeks.org/problems/count-the-paths4332/1
 https://leetcode.com/problems/all-paths-from-source-to-target/submissions/
*/

class Solution {
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        int dest=graph.size()-1;
        int source=0;
        
        vector<vector<int>> result;
        vector<int> path;
        dfs(graph,result,path,source,dest);
        return result;
    }
    
    void dfs(vector<vector<int>> &graph, vector<vector<int>> &result,
             vector<int> &path, int u,int dest){
        path.push_back(u);
        if(u==dest)
            result.push_back(path);
        else
        {
            for(int v:graph[u]){
                dfs(graph,result,path,v,dest);
            }
        }
        
        path.pop_back();
        
    }
};