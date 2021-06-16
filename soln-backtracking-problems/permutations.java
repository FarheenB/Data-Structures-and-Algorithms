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
    
    public void possiblePermutation(int nums[], List<Integer> arrangement, List<List<Integer>> result){
        if(arrangement.size()==nums.length){
            result.add(new ArrayList<>(arrangement));
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(arrangement.contains(nums[i]))
                    continue;
                arrangement.add(nums[i]);
                possiblePermutation(nums,arrangement,result);
                arrangement.remove(arrangement.size()-1);
            }
        }
    }    
}
