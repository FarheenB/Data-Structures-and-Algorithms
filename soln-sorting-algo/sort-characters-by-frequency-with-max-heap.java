/*
https://leetcode.com/problems/sort-characters-by-frequency/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }      
        
        PriorityQueue<Character> maxHeap=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        maxHeap.addAll(map.keySet());
        
        StringBuilder str=new StringBuilder();
        
        while(!maxHeap.isEmpty()){
            char ch=maxHeap.remove();
            for(int i=1;i<=map.get(ch);i++){
                str.append(ch);
            }
        }
        return str.toString();       
    }
}