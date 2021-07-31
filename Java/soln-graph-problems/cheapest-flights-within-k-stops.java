/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/cheapest-flights-within-k-stops
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
    int city;
    int price;
    int stops;
    Node(int city, int price, int stops){
        this.city=city;
        this.price=price;
        this.stops=stops;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] adj_matrix=new int[n][n];
        for(int flight[]:flights)
            adj_matrix[flight[0]][flight[1]]=flight[2];
        
        PriorityQueue<Node> minHeap=new PriorityQueue<>((a,b)->a.price-b.price);
        minHeap.add(new Node(src,0,-1));
        
        while(!minHeap.isEmpty()){
            Node node=minHeap.remove();
            if(node.city==dst)
                return node.price;

            if(node.stops<K){                                
                for(int i=0;i<n;i++){
                    if(adj_matrix[node.city][i]!=0)
                        minHeap.add(new Node(i,adj_matrix[node.city][i]+node.price,node.stops+1));
                }
            }
        }
        return -1;
    }
}
