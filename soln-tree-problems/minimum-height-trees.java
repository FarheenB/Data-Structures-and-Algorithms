/*
https://leetcode.com/problems/minimum-height-trees
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            ArrayList<Integer> leaves = new ArrayList<>();     
            leaves.add(0);
            return leaves;
        }            
        
        ArrayList<Set<Integer>> adj_list=new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj_list.add(new HashSet<Integer>());
        
        for(int[] row:edges){
            adj_list.get(row[0]).add(row[1]);
            adj_list.get(row[1]).add(row[0]);
        }
        
        ArrayList<Integer> leaves = new ArrayList<>();     
        for(int i=0;i<adj_list.size();i++)
            if(adj_list.get(i).size()==1)
                leaves.add(i);
        
        while(n>2){
            int len=leaves.size();
            n=n-len;
            ArrayList<Integer> newLeaves = new ArrayList<>();
            
            for(Integer leaf:leaves){
                Integer val = adj_list.get(leaf).iterator().next();
                adj_list.get(val).remove(leaf);
                if (adj_list.get(val).size() == 1)
                    newLeaves.add(val);
            }
            
            leaves=newLeaves;
        }
    
        return leaves;
    }
}