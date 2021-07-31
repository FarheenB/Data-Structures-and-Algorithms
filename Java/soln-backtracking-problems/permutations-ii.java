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
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        possiblePermutation(nums,new ArrayList<>(),new ArrayList<>(),result);
        return result;
    }    
    
    public void possiblePermutation(int nums[], List<Integer> arrangement,List<Integer> occur_indx, List<List<Integer>> result){
        if(arrangement.size()==nums.length && !result.contains(arrangement)){
            result.add(new ArrayList<>(arrangement));
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(occur_indx.contains(i))
                    continue;
                
                arrangement.add(nums[i]);
                occur_indx.add(i);
                possiblePermutation(nums,arrangement,occur_indx,result);
                arrangement.remove(arrangement.size()-1);
                occur_indx.remove(occur_indx.size()-1);
            }
        }
    }    
}
