/*
https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Traversal {
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) {
        ArrayList<Integer> bfsList=new ArrayList<>();
        boolean visited[]=new boolean[N];
        int s=0;
        
        Queue<Integer> queue=new LinkedList<>();
        queue.add(s);
        visited[s]=true;
        while(!queue.isEmpty()){
            int node=queue.remove();
            bfsList.add(node);     
            for(int adj_node:g.get(node)){
                if(!visited[adj_node]){
                    visited[adj_node]=true;
                    queue.add(adj_node);
                }
            }
        }
        return bfsList;
    }
}