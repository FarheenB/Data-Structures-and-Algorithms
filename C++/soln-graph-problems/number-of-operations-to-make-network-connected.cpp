/**
 @author Farheen Bano

 Date 24-07-2021

 Reference-
 https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 NOTE: Variation of Connected Components in a graph
*/

class Solution {
public:
    int makeConnected(int n, vector<vector<int>>& connections) {
        if(connections.size()<n-1)
            return -1;
        
        vector<int> adj_list[n];
        vector<bool> visited(n,false);

        
        //form adjacency list for undirected graph        
        for(int i=0;i<connections.size();i++){
            adj_list[connections[i][0]].push_back(connections[i][1]);
            adj_list[connections[i][1]].push_back(connections[i][0]);
        }
        
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i, visited, adj_list);
            }
        }
        return connections.size()>=n-1?count-1:-1;
    }
    
    
    void dfs(int node,vector<bool>& visited,vector<int> adj_list[]){
        visited[node]=true;
        for(int adj_node:adj_list[node]){
            if(!visited[adj_node])
                dfs(adj_node, visited, adj_list);
        }
    }
};