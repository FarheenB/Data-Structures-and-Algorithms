/*
https://practice.geeksforgeeks.org/problems/subsets-1587115621/1
https://leetcode.com/problems/subsets-ii
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    List<List<Integer>> result=new ArrayList<>();  
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        if(nums==null || nums.length==0)
            return result;
        
        List<Integer> list=new ArrayList<Integer>();
        solve(nums,0,list);
        return result;
    }
    
    public void solve(int[] nums, int index, List<Integer> list){
        if(result.contains(list))
            return;
        if(index==nums.length){
            result.add(list);
            return;
        }       

        ArrayList<Integer> new_list=new ArrayList<>(list);
        list.add(nums[index]);
        solve(nums,index+1,list);
        solve(nums,index+1,new_list);
    }
}