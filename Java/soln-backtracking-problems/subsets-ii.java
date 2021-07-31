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
    
    public void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets){
        if(!subsets.contains(current))
            subsets.add(new ArrayList<>(current));
        for(int i=index;i<nums.length;i++){
            current.add(nums[i]);
            generateSubsets(i+1,nums,current,subsets);
            current.remove(current.size()-1);
        }
    }
}
