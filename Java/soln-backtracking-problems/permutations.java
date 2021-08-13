/**
 @author Farheen Bano
  
 References-
 https://www.interviewbit.com/problems/permutations/
 https://leetcode.com/problems/permutations/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {        
        List<List<Integer>> result=new ArrayList<>();
        possiblePermutation(nums,new ArrayList<>(),result);
        return result;
    }
    
    public void possiblePermutation(int nums[], List<Integer> cur, List<List<Integer>> result){
        if(cur.size()==nums.length)
            result.add(new ArrayList<>(cur));
        
        else{
            for(int i=0;i<nums.length;i++){
                if(cur.contains(nums[i]))
                    continue;
                cur.add(nums[i]);
                possiblePermutation(nums,cur,result);
                cur.remove(cur.size()-1);
            }
        }
    }    
}
