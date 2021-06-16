/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/sort-array-by-increasing-frequency
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }      
        
        PriorityQueue<Integer> minHeap=new PriorityQueue<>((a,b)->map.get(a)==map.get(b)?b-a:map.get(a)-map.get(b));
        minHeap.addAll(map.keySet());
        
        int[] result=new int[nums.length];
        int ind=0;
        
        while(!minHeap.isEmpty()){
            int num=minHeap.remove();
            for(int i=1;i<=map.get(num);i++){
                result[ind++]=num;
            }
        }
        return result;        
    }
}
