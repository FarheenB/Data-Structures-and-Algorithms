/*
https://leetcode.com/problems/network-delay-time/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Pair{
    int vertex;
    int time;
    Pair(int vertex, int time){
        this.vertex=vertex;
        this.time=time;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Pair>[] adj_list=new ArrayList[n+1];
        for(int i=0;i<n+1;i++)
            adj_list[i]=new ArrayList<>();
        
        for(int edge[]:times){
            adj_list[edge[0]].add(new Pair(edge[1],edge[2]));
        }
        
        int time[]=dijsktra(k,adj_list,n);  
        int max=-1;
        int count=0;
        for(int dist:time){
            if(dist!=Integer.MAX_VALUE)
                max=Math.max(max,dist);
            else{
                count++;
                if(count>1)
                    break;
            }
        }
        return count>1?-1:max;
        
    }
     public int[] dijsktra(int src, ArrayList<Pair>[] adj_list, int n){
        int[] time=new int[n+1];
        Arrays.fill(time,Integer.MAX_VALUE);
        
        PriorityQueue<Pair> minHeap=new PriorityQueue<>((a,b)->a.time-b.time);
        minHeap.add(new Pair(src,0));
        time[src]=0;
        
        while(!minHeap.isEmpty()){
            Pair node=minHeap.remove();
            for(Pair adj_nodes:adj_list[node.vertex]){
                int newDistance=time[node.vertex]+adj_nodes.time;
                if(newDistance<time[adj_nodes.vertex]){
                    time[adj_nodes.vertex]=newDistance;
                    minHeap.add(new Pair(adj_nodes.vertex,newDistance));
                }
            }
        }
        return time;
    }
}