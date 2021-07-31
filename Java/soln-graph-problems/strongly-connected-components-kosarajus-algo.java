/**
 @author Farheen Bano
  
 Reference-
 https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class Solution
{
    boolean[] visited;
    Stack<Integer> stack=new Stack<>();
    ArrayList<ArrayList<Integer>> adj_list;
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        adj_list=adj;
        
        visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i])
                findOrder(i);
        }
        
        ArrayList<ArrayList<Integer>> reverse_adj_list=transpose(V);
        
        visited=new boolean[V];
        int count=0;
        while(!stack.isEmpty()){
            int node=stack.pop();
            if(!visited[node]){
                dfs(node,reverse_adj_list);
                count++;
            }
        }
        return count;
    }
    
    public void findOrder(int node){
        visited[node]=true;
        
        for(int adj_node:adj_list.get(node)){
            if(!visited[adj_node])
                findOrder(adj_node);
        }
        stack.push(node);
    }
    
    ArrayList<ArrayList<Integer>> transpose(int V){
        ArrayList<ArrayList<Integer>> reverse_adj_list=new ArrayList<>();
        for(int i=0;i<V;i++)
            reverse_adj_list.add(i,new ArrayList<>());
            
        for(int i=0;i<V;i++){
            for(int adj_node:adj_list.get(i)){
                reverse_adj_list.get(adj_node).add(i);
            }
        }
        return reverse_adj_list;
    }
    
    public void dfs(int node, ArrayList<ArrayList<Integer>> reverse_adj_list){
        visited[node]=true;
        
        for(int adj_node:reverse_adj_list.get(node)){
            if(!visited[adj_node])
                dfs(adj_node,reverse_adj_list);
        }
    }
}
