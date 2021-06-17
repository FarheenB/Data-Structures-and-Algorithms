/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/longest-harmonious-subsequence/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int max_length=0;
        
        for(int key:map.keySet()){
            if(map.containsKey(key+1)){
                max_length=Math.max(max_length,(map.get(key)+map.get(key+1)));
            }
        }
        return max_length;
    }
}