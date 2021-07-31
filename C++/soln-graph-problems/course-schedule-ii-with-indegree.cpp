/**
 @author Farheen Bano
  
 Date 24-07-2021

 Reference-
 https://leetcode.com/problems/course-schedule-ii/
*/

class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> adj_list(numCourses);
        vector<int> course_order;   
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
        
        int takenCourses=0;
        while(!q.empty()){
            int node=q.front();
            q.pop();
            course_order.push_back(node);
            takenCourses++;
            for(int adj_node:adj_list[node]){
                indegree[adj_node]--;
                if(indegree[adj_node]==0)
                    q.push(adj_node);
            }
        }
        
        vector<int> res;
        if(takenCourses!=numCourses)
            return res;
        vector<int> result(course_order.size());
        for(int i=0;i<course_order.size();i++){
            result[i]=course_order[i];
        }
        return result;
    }
};
