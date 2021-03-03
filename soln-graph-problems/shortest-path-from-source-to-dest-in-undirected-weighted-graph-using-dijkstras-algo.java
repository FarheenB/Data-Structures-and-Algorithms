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
	public static void dijkstra(int[][] adj_matrix, int source, int dest){
    	int n=adj_matrix.length;
    	int[] distance=new int[n];
    	Arrays.fill(distance,-1);
    	int[] pred=new int[n+1];
    	Arrays.fill(pred,-1);
    	
    	PriorityQueue<Pair> minHeap=new PriorityQueue<>((a,b)->a.w-b.w);
    	minHeap.add(new Pair(source,0));
    	distance[source]=0;
    	
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
  