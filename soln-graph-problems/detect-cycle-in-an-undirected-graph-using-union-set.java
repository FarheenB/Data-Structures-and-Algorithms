/*
https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1#
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    int[] parent;
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<int[]> edges=new ArrayList<>();
        for(int i=0;i<adj.size();i++){
            for(int nodes:adj.get(i)){
                if(nodes>i)
                    edges.add(new int[]{i,nodes});
            }
        }

        parent=new int[V];
        for(int i=0;i<V;i++)
            parent[i]=i;        
       
        for(int[] edge:edges){
            int x=find(edge[0]);
            int y=find(edge[1]);            
            if(x==y)
                return true;
            union(edge[0],edge[1]);
        }
        return false;
    }
               
    public int find(int i){
        while(parent[i]!=i){
            i=parent[i];
        }
        return i;
    }
    
    public void union(int a, int b){
        int x=find(a);
        int y=find(b);
        parent[x]=parent[y];
    } 
}
