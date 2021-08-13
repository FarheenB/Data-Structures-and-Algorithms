/**
 @author Farheen Bano
  
 References-
 https://www.interviewbit.com/problems/all-unique-permutations/
 https://leetcode.com/problems/permutations-ii/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    HashMap<Integer,Integer> counts=new HashMap<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        
        HashMap<Integer,Integer> counter=new HashMap<>();
        for(int num:nums)
            counter.put(num,counter.getOrDefault(num,0)+1);    
        
        possiblePermutation(nums,new ArrayList<>(),counter,result);
        return result;
    }    
    
    public void possiblePermutation(int nums[], List<Integer> cur,HashMap<Integer,Integer> counter, List<List<Integer>> result){
        if(cur.size()==nums.length)
            result.add(new ArrayList<>(cur));
        
        else{
            for(int num : counter.keySet()){
                if(counter.get(num) > 0){
                    counter.put(num,counter.get(num)-1);
                    cur.add(num);
                    possiblePermutation(nums,cur,counter,result);
                    cur.remove(cur.size()-1);
                    counter.put(num,counter.get(num)+1);
                }
            }
        }
    }    
}