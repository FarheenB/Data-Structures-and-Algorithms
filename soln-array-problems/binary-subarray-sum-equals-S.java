/*
https://leetcode.com/problems/binary-subarrays-with-sum/
*/ 

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        HashMap<Integer,Integer> map=new HashMap<>();        
        int sum=0;  
        int count=0;
        map.put(0,1);
        for(int i=0;i<A.length;i++){
            sum+=A[i];
            if(map.containsKey(sum-S))
                count+=map.get(sum-S);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}