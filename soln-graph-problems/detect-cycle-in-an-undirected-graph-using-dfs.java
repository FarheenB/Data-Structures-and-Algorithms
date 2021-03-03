/*
https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1#
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    ArrayList<ArrayList<Integer>> adj_list;
    int[] visited;
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        adj_list=adj;
        visited=new int[V];
        
        for(int i=0;i<V;i++){
            if(visited[i]==0 && dfs(i, -1))
                return true;
        }
        return false;
    }
    
    public boolean dfs(int node, int parent){
        if(visited[node]==2)
            return false;

        visited[node]=1;
        for(int adj_node:adj_list.get(node)){
            if(adj_node!=parent){
                if(visited[adj_node]==1 || dfs(adj_node,node))
                    return true;
            }
        }         
        
        visited[node]=2;
        return false;
    }
}