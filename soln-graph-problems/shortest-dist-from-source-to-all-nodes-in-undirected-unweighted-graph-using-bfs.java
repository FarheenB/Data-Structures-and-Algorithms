import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void printShortestDistance(ArrayList<ArrayList<Integer>> adj, int source, int v){
    	int[] distance=new int[v];
    	Arrays.fill(distance,-1);
    	int[] pred=new int[v];
    	
    	Queue<Integer> queue=new LinkedList<>();
    	queue.add(source);
    	distance[source]=0;
    	pred[source]=source;
    	
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
 
        // Print distances and paths
        System.out.println("From "+source+" to:");
        for (int i=0;i<v;i++) {
            System.out.println(i + " is Distance="+distance[i]+" via Node="+ pred[i]);
        }
    }
}