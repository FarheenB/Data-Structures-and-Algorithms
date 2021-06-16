/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/top-k-frequent-elements
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }      
        
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(k, (a,b)->map.get(a)==map.get(b)?b-a:map.get(a)-map.get(b));
        
        for(int key:map.keySet()){
            minHeap.add(key);
            if(minHeap.size()>k){
                minHeap.remove();
            }
        }
        
        int[] result=new int[minHeap.size()];
        
        int ind=0;
        while(!minHeap.isEmpty()){
            int num=minHeap.remove();
            result[ind++]=num;
        }
        return result;        
    }
}
