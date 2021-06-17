/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/number-of-provinces/

 NOTE: Finding all connected component in a graph 
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] adj_list;

    public int findCircleNum(int[][] M) {
        int n=M.length;
        adj_list=new ArrayList[n];
        visited=new boolean[n];
               
        for(int i=0;i<n;i++)
            adj_list[i]=new ArrayList<>();        
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                if(M[i][j]==1)
                    adj_list[i].add(j);
            }
        }
        
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }
        return count;
    }    
    
    public static void dfs(int node){
        visited[node]=true;
        for(int adj_node:adj_list[node]){
            if(!visited[adj_node])
                dfs(adj_node);
        }
    }
}