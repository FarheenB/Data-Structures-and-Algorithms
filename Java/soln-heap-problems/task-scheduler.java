/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/task-scheduler/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks.length==0)
            return 0;
        
        if(n==0)
            return tasks.length;
        
        HashMap<Character,Integer> map=new HashMap<>();
        for(char task:tasks){
            map.put(task,map.getOrDefault(task,0)+1);
        }
        
        PriorityQueue<Character> maxHeap=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        maxHeap.addAll(map.keySet());
        
        int cycles=0;
        while(!maxHeap.isEmpty()){
            ArrayList<Character> seq=new ArrayList<>();
            for(int i=0;i<n+1;i++){
                if(!maxHeap.isEmpty()){
                    char freq_task=maxHeap.remove();
                    seq.add(freq_task);
                    map.put(freq_task,map.get(freq_task)-1);
                } 
            }            
            
            for(char task:seq){
                if(map.get(task)>0){
                    maxHeap.add(task);                    
                }
            }
            cycles+=maxHeap.isEmpty()?seq.size():n+1;
        }
        return cycles;
    }
}
