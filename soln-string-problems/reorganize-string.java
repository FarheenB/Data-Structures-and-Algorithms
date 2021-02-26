/*
https://leetcode.com/problems/reorganize-string/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public String reorganizeString(String S) {
        Map<Character, Integer> counts=new HashMap<>();
        for(char ch:S.toCharArray())
            counts.put(ch, counts.getOrDefault(ch,0)+1);
        
        PriorityQueue<Character> maxHeap=new PriorityQueue<>((a,b)->counts.get(b)-counts.get(a));
        maxHeap.addAll(counts.keySet());
        
        StringBuilder result=new StringBuilder();
        while(maxHeap.size()>1){
            //remove the most two frequently occuring character 
            char current=maxHeap.remove();
            char next=maxHeap.remove();
            
            //Greedy Algorithm
            result.append(current);
            result.append(next);
            counts.put(current,counts.get(current)-1);
            counts.put(next,counts.get(next)-1);
            
            if(counts.get(current)>0){
                maxHeap.add(current);
            }
            if(counts.get(next)>0){
                maxHeap.add(next);
            }
        }
        if(!maxHeap.isEmpty()){
            char last=maxHeap.remove();
            if(counts.get(last)>1)
                return "";
            result.append(last);                
        }
        return result.toString();
    }
}