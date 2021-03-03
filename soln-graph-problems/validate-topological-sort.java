/*
https://practice.geeksforgeeks.org/problems/topological-sort/1#
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static int[] indegree;
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result=new ArrayList<>();
        indegree=new int[V];
        
        for(ArrayList<Integer> nodes:adj){
            for(int v:nodes)
                indegree[v]++;
        }
        
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0)
                queue.add(i);
        }
        
        while(!queue.isEmpty()){
            int node=queue.remove();
            result.add(node);
            for(int adj_node:adj.get(node)){
                indegree[adj_node]--;
                if(indegree[adj_node]==0)
                    queue.add(adj_node);
            }
        }
        
        int[] topo_order=new int[result.size()];
        for(int i=0;i<result.size();i++)
            topo_order[i]=result.get(i);
        return topo_order;
    }
}