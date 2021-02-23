/*
https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {        
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(k, (a,b)->map.get(a)==map.get(b)?b-a:map.get(b)-map.get(a));
        
        for(int i=0;i<mat.length;i++){
            int count=0;
            
            int start=0;
            int end=mat[0].length-1;
            while(start<=end){
                int mid=start+(end-start)/2;
                if(mat[i][mid]==1)
                    start=mid+1;   
                else
                    end=mid-1;
            }
            count=start;
            map.put(i,count);
            
            maxHeap.add(i);
            if(maxHeap.size()>k)
                maxHeap.poll();
        }
        
        int[] result=new int[k];
        int ind=k-1;
        while(!maxHeap.isEmpty()){
            result[ind--]=maxHeap.poll();
        }
        return result;
    }
}