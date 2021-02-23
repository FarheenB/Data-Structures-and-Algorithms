/*
https://leetcode.com/problems/is-graph-bipartite
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    Map<Integer,ArrayList<Integer>> adj_list=new HashMap<>();
    Map<Integer,Integer> color_list=new HashMap<>();
    
    public boolean isBipartite(int[][] graph) {
        for(int i=0;i<graph.length;i++){
            ArrayList<Integer> nodes=new ArrayList<>();
            
            for(int n:graph[i]){
                nodes.add(n);
            }
            adj_list.put(i,nodes);
            color_list.put(i,-1);
        }
        
        for(int v:adj_list.keySet()){
            if(color_list.get(v)==-1 && !bfs(v))
                    return false;
        }
        return true;
    }
    
    public boolean bfs(int v){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(v);
        color_list.put(v,0);
        
        while(!queue.isEmpty()){
            int cur=queue.poll();
            int cur_color=color_list.get(cur);
            
            for(int u:adj_list.get(cur)){
                if(color_list.get(u)==cur_color)
                    return false;
                
                if(color_list.get(u)==-1){
                    queue.add(u);
                    color_list.put(u,1-cur_color);
                }
            }
        }
        return true;
    }
}