/*
https://leetcode.com/problems/subarrays-with-k-different-integers
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A,K)-atMostK(A,K-1);
    }
        
    public int atMostK(int[] A, int K){ 
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int i=0;
        int j=0;
        int count=0;
        
        while(j<A.length){
            map.put(A[j],map.getOrDefault(A[j],0)+1);
            
            while(map.size()>K){
                map.put(A[i],map.get(A[i])-1);
                if(map.get(A[i])==0){
                    map.remove(A[i]);
                }
                i++;
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
}