/*
https://leetcode.com/problems/course-schedule/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static int[] indegree;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        ArrayList<Integer>[] adj_list=new ArrayList[n];
        for(int i=0;i<n;i++)
            adj_list[i]=new ArrayList<>();
        for(int edge[]:prerequisites)
            adj_list[edge[1]].add(edge[0]);
        
        indegree=new int[n];        
        for(ArrayList<Integer> nodes:adj_list){
            for(int v:nodes)
                indegree[v]++;
        }
        
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)
                queue.add(i);
        }
        
        int order=0;
        while(!queue.isEmpty()){
            int node=queue.remove();
            order++;
            for(int adj_node:adj_list[node]){
                indegree[adj_node]--;
                if(indegree[adj_node]==0)
                    queue.add(adj_node);
            }
        }
        
        return order==n;
    }
}