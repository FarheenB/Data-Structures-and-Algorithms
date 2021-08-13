/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/subsets-ii/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets=new ArrayList<>();
        generateSubsets(0,nums, new ArrayList<Integer>(),subsets);
        return subsets;
        
    }
    
    public void generateSubsets(int index, int[] nums, List<Integer> cur, List<List<Integer>> subsets){
        subsets.add(new ArrayList<>(cur));
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1])
                continue;
            cur.add(nums[i]);
            generateSubsets(i+1,nums,cur,subsets);
            cur.remove(cur.size()-1);
        }
    }
}
