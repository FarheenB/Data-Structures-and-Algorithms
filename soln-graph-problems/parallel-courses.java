/*
https://leetcode.com/problems/parallel-courses
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static int[] indegree;
    public int minimumSemesters(int n, int[][] relations) {
        ArrayList<Integer>[] adj_list=new ArrayList[n+1];
        for(int i=0;i<n+1;i++)
            adj_list[i]=new ArrayList<>();
        for(int edge[]:relations)
            adj_list[edge[0]].add(edge[1]);
        
        indegree=new int[n+1];
        
        for(ArrayList<Integer> nodes:adj_list){
            for(int v:nodes)
                indegree[v]++;
        }
        
        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<n+1;i++){
            if(indegree[i]==0)
                queue.add(i);
        }
        
        int semester=0;
        int order=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            semester++;

            for(int i=0;i<size;i++){
                int node=queue.remove();
                order++;
                for(int adj_node:adj_list[node]){
                    indegree[adj_node]--;
                    if(indegree[adj_node]==0)
                        queue.add(adj_node);
                }
            }
        }
        
        return order!=n?-1:semester;
    }
}
    