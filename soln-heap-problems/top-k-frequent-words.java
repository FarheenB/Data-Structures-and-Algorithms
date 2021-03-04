/*
https://leetcode.com/problems/top-k-frequent-words/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        
        PriorityQueue<String> minHeap=new PriorityQueue<>(k,(a,b)->map.get(a)==map.get(b)?b.compareTo(a):map.get(a)-map.get(b));

        for(String key:map.keySet()){
            minHeap.add(key);
            if(minHeap.size()>k){
                minHeap.remove();
            }
        }
        
        List<String> result=new ArrayList<>();
        while(!minHeap.isEmpty()){
            result.add(minHeap.remove());
        }
        Collections.reverse(result);
        return result;       
    }
}