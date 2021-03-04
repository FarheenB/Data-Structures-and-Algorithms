/*
https://practice.geeksforgeeks.org/problems/count-the-paths4332/1
https://leetcode.com/problems/all-paths-from-source-to-target/submissions/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    boolean[] visited;
    int[][] adj_list;
    List<List<Integer>> possible_paths=new ArrayList<>();
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if(graph==null)
            return null;
        
        int s=0;
        int d=0;
        for(int edges[]:graph)
            for(int v:edges)
                d=Math.max(d,v);
        int n=d+1;        
        adj_list=graph;
        visited=new boolean[n];     
        List<Integer> path=new ArrayList<>();
        path.add(s);
        dfs(s,d,path);
        return possible_paths;
    }
    
    public void dfs(int source, int dest, List<Integer> path){
        if(source==dest){
            possible_paths.add(new ArrayList<>(path));            
            return;            
        }
  
        visited[source]=true;

        for(int adj_node:adj_list[source]){
            if(!visited[adj_node]){        
                path.add(adj_node);
                dfs(adj_node,dest,path);
                path.remove(path.size()-1);
            }
        }
        visited[source]=false;
    }
}