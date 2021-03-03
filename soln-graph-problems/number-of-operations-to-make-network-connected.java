/*
https://leetcode.com/problems/number-of-operations-to-make-network-connected/

NOTE: Variation of Connected Components in a graph
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    boolean[] visited;
    ArrayList<Integer>[] adj_list;

    public int makeConnected(int n, int[][] connections) {
        adj_list=new ArrayList[n];
        visited=new boolean[n];
        
        //form adjacency list for undirected graph        
        for(int i=0;i<n;i++)
            adj_list[i]=new ArrayList<>();        
        for(int edge[]:connections){
            adj_list[edge[0]].add(edge[1]);
            adj_list[edge[1]].add(edge[0]);
        }
        
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }
        return connections.length>=n-1?count-1:-1;
    }    
    
    public void dfs(int node){
        visited[node]=true;
        for(int adj_node:adj_list[node]){
            if(!visited[adj_node])
                dfs(adj_node);
        }
    }
}