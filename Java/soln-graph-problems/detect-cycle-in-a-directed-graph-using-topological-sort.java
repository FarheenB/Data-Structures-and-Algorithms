/**
 @author Farheen Bano
  
 Reference-
 https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static int[] indegree;    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
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
        
        int order=0;
        while(!queue.isEmpty()){
            int node=queue.remove();
            order++;
            for(int adj_node:adj.get(node)){
                indegree[adj_node]--;
                if(indegree[adj_node]==0)
                    queue.add(adj_node);
            }
        }

        return order!=V;
    }
}
