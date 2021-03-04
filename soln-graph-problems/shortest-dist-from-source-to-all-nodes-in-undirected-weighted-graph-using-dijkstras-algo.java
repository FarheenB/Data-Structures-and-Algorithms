/*
https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Pair{
    int v;
    int w;
    Pair(int v, int w){
    	this.v=v;
    	this.w=w;
    }
}
class Solution{   
    public static void dijkstra(int[][] adj_matrix, int source){
        int n=adj_matrix.length;
        int[] distance=new int[n];
        Arrays.fill(distance,-1);
        int[] pred=new int[n+1];
        Arrays.fill(pred,-1);

        PriorityQueue<Pair> minHeap=new PriorityQueue<>((a,b)->a.w-b.w);
        minHeap.add(new Pair(source,0));
        distance[source]=0;
        pred[source]=source;

        while(!minHeap.isEmpty()){
        	Pair vertex_pair=minHeap.remove();
        	int node=vertex_pair.v;
        	
        	for(int i=0;i<n;i++){
        		if(adj_matrix[node][i]!=0){
        			int weight=adj_matrix[node][i];
        			int newDistance=distance[node]+weight;
        			if(distance[i]==-1 || distance[i]>newDistance){
        				distance[i]=newDistance;
            			minHeap.add(new Pair(i,distance[i]));
            			pred[i]=node;
        			}
        		}
        	}
        }
    	
    	System.out.println("From "+source+" to:");
        for (int i=0;i<n;i++) 
            System.out.println(i + " is Distance="+distance[i]+" via Node="+ pred[i]);
    }
}   
