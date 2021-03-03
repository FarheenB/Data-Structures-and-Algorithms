/*
https://leetcode.com/problems/min-cost-to-connect-all-points/

NOTE: Using Kruskal's Algorithm
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    int[] parent;
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        if(n<=1)
            return 0;
        
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int dist=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                minHeap.add(new int[]{i,j,dist});
            }
        }
        
        parent=new int[n];
        for(int i=0;i<n;i++)
            parent[i]=i;
            
        int edgeCount=0;
        int sum=0;
        
        while(edgeCount<n-1){            
            int[] edge=minHeap.poll();            
            if(find(edge[0])!=find(edge[1])){                
                union(edge[0],edge[1]);
                edgeCount++;
                sum+=edge[2];
            }
        }
        return sum;
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
