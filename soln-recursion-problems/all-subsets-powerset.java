/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/subsets/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    List<List<Integer>> result=new ArrayList<>();    
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0)
            return result;
        
        List<Integer> list=new ArrayList<Integer>();
        solve(nums,0,list);
        return result;
    }
    
    public void solve(int[] nums, int index, List<Integer> list){
        if(index==nums.length){
            result.add(list);
            return;
        }
        List<Integer> newList=new ArrayList<>(list);
        newList.add(nums[index]);
        solve(nums,index+1,newList);
        solve(nums,index+1,list);
    }
}
