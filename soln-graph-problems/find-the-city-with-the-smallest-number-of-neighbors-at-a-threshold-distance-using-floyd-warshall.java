/*
https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adj_matrix=new int[n][n];        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                adj_matrix[i][j]=10001;
            adj_matrix[i][i]=0;
        }
        
        for(int edge[]:edges){
            adj_matrix[edge[0]][edge[1]]=edge[2];
            adj_matrix[edge[1]][edge[0]]=edge[2];
        }
        
        floyd_warshall(adj_matrix, n);
        
        int reachableCities=n;
        int result=0;
        for(int i=0;i<n;i++){
            int count=0;
            for(int dist:adj_matrix[i]){
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
    
    public void floyd_warshall(int[][] dist, int n){
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][j]>dist[i][k]+dist[k][j])
                        dist[i][j]=dist[i][k]+dist[k][j];
                }
            }
        }
    }
}