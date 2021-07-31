/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/course-schedule-iv/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static int[] indegree;
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] allPrereq=new boolean[n][n];
        List<Boolean> result=new ArrayList<>();   
        if(queries==null || queries.length==0)
            return result;
                
        ArrayList<Integer>[] adj_list=new ArrayList[n];
        for(int i=0;i<n;i++)
            adj_list[i]=new ArrayList<>();
        for(int edge[]:prerequisites)
            adj_list[edge[0]].add(edge[1]);
        
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
        
        while(!queue.isEmpty()){
            int node=queue.remove();
            for(int adj_node:adj_list[node]){

                for(int i=0;i<n;i++){
                    if(allPrereq[node][i] || node==i)
                        allPrereq[adj_node][i]=true;
                }
                indegree[adj_node]--;
                if(indegree[adj_node]==0)
                    queue.add(adj_node);            
            }
        }

        for(int query[]:queries)
            result.add(allPrereq[query[1]][query[0]]);
        
        return result;
    }
}
     