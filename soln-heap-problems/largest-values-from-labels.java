/*
https://leetcode.com/problems/largest-values-from-labels
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Item{
    int label;
    int value;
    Item(int label,int value){
        this.label=label;
        this.value=value;
    }
}

class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        List<Item> list=new ArrayList<>();
        for(int i=0;i<values.length;i++){
            list.add(new Item(labels[i],values[i]));
        }
        
        PriorityQueue<Item> maxHeap=new PriorityQueue<>((a,b)->b.value-a.value);
        maxHeap.addAll(list);
   
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(!maxHeap.isEmpty() && num_wanted>0){
            Item current=maxHeap.remove();
            map.put(current.label,map.getOrDefault(current.label,0)+1);
            if(map.get(current.label)<=use_limit){
                sum+=current.value;
                num_wanted--;
            }                
        }
        return sum;
    }
}