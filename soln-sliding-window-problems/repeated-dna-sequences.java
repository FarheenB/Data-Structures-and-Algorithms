/*
https://leetcode.com/problems/repeated-dna-sequences
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        StringBuilder str=new StringBuilder();
        
        while(j<s.length()){
            if(str.length()<10)
                str.append(s.charAt(j));
            
            if(str.length()==10){
                String seq=str.toString();
                map.put(seq,map.getOrDefault(seq,0)+1);
                if(map.get(seq)>1 && !result.contains(seq))
                    result.add(seq);                
                str.deleteCharAt(0);
                i++;                
            }            
            j++;            
        }
        return result;
    }
}