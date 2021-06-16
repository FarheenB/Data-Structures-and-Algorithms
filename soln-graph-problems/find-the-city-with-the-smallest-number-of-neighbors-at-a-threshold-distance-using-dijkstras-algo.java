/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Pair{
    int city;
    int distance;
    Pair(int city, int distance){
        this.city=city;
        this.distance=distance;
    }
}
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<Pair>[] adj_list=new ArrayList[n];
        for(int i=0;i<n;i++)
            adj_list[i]=new ArrayList<>();
        
        for(int edge[]:edges){
            adj_list[edge[0]].add(new Pair(edge[1],edge[2]));
            adj_list[edge[1]].add(new Pair(edge[0],edge[2]));
        }
        
        int reachableCities=n;
        int result=0;
        for(int i=0;i<n;i++){
            int distance[]=dijsktra(i,adj_list,n);           

            int count=0;
            int index=0;
            for(int dist:distance){
                if(dist<=distanceThreshold)
                    count++;
            }
            if(count<=reachableCities){
                result=i;
                reachableCities=count;                    
            }
        }
        return result;
    }
    
    public int[] dijsktra(int src, ArrayList<Pair>[] adj_list, int n){
        int[] distance=new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        
        PriorityQueue<Pair> minHeap=new PriorityQueue<>((a,b)->a.distance-b.distance);
        minHeap.add(new Pair(src,0));
        distance[src]=0;
        
        while(!minHeap.isEmpty()){
            Pair node=minHeap.remove();
            for(Pair adj_nodes:adj_list[node.city]){            
                int newDistance=distance[node.city]+adj_nodes.distance;
                if(newDistance<distance[adj_nodes.city]){
                    distance[adj_nodes.city]=newDistance;
                    minHeap.add(new Pair(adj_nodes.city,newDistance));
                }
            }
        }
        return distance;
    }
}
