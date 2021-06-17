/**
 @author Farheen Bano
  
 Reference-
 https://www.geeksforgeeks.org/shortest-path-unweighted-graph/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static void printShortestDistance(ArrayList<ArrayList<Integer>> adj, int source, int dest, int v){
    	int[] distance=new int[v];
    	Arrays.fill(distance,-1);
    	int[] pred=new int[v];
    	Arrays.fill(pred,-1);
    	
    	Queue<Integer> queue=new LinkedList<>();
    	queue.add(source);
    	distance[source]=0;
    	pred[source]=-1;
    	
    	while(!queue.isEmpty()){
    		int size=queue.size();
    		for(int i=0;i<size;i++){
    			int node=queue.remove();
	    		for(int adj_node:adj.get(node)){
	    			if(distance[adj_node]==-1){
	    				distance[adj_node]=distance[node]+1;	
		    			queue.add(adj_node);
		    			pred[adj_node]=node;
	    			}
	    		}
    		}
    	}
      
	    ArrayList<Integer> path=new ArrayList<>();
		if(distance[dest]!=-1){
			int x=dest;
			path.add(x);
			while(pred[x]!=-1){
				path.add(0,pred[x]);
				x=pred[x];
			}
		}
		else{
			System.out.println("Source and Destination are not connected");
			return;
		}
		
		System.out.println("Shortest Path from "+source+" to "+dest );
		for(int nodes:path)
			System.out.print(nodes+" ");	
    }
}