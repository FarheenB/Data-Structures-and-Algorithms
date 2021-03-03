/*
https://leetcode.com/problems/redundant-connection
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        
        parent=new int[n+1];
        for(int i=1;i<n+1;i++)
            parent[i]=i;        
       
        for(int[] edge:edges){
            int x=find(edge[0]);
            int y=find(edge[1]);            
            if(x==y)
                return edge;
            union(edge[0],edge[1]);
        }
        return null;
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
