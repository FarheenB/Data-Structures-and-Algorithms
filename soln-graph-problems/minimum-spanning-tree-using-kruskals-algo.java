/*
https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1#
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static int[] parent;
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int i=0;i<V;i++){
            for(ArrayList<Integer> edge:adj.get(i))
                minHeap.add(new int[]{i,edge.get(0),edge.get(1)});
        }
        
        parent=new int[V];
        for(int i=0;i<V;i++)
            parent[i]=i;
            
        int edgeCount=0;
        int sum=0;
        
        while(edgeCount<V-1){            
            int[] edge=minHeap.poll();            
            if(find(edge[0])!=find(edge[1])){                
                union(edge[0],edge[1]);
                edgeCount++;
                sum+=edge[2];
            }
        }
        return sum;
    }
               
    static public int find(int i){
        while(parent[i]!=i){
            i=parent[i];
        }
        return i;
    }
    
    static public void union(int a, int b){
        int x=find(a);
        int y=find(b);
        parent[x]=parent[y];
    } 
}
