/**
 @author Farheen Bano
  
 Date 24-07-2021
 
 Reference-
 https://leetcode.com/problems/course-schedule/
*/

class Solution {
public:

    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> adj_list(numCourses);
        vector<int> indegree(numCourses,0);   

        for(auto edge:prerequisites)
            adj_list[edge[1]].push_back(edge[0]);
        
        for(auto nodes:adj_list){
            for(int v:nodes)
                indegree[v]++;
        }
        
        queue<int> q;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                q.push(i);
        }
        
        int order=0;
        while(!q.empty()){
            int node=q.front();
            q.pop();
            order++;
            for(int adj_node:adj_list[node]){
                indegree[adj_node]--;
                if(indegree[adj_node]==0)
                    q.push(adj_node);
            }
        }
        
        return order==numCourses;
    }
};