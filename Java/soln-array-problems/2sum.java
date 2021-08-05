/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/two-sum/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] twoSum(int[] nums, int target){
        if(nums.length<2)
            return new int[2];
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int other=target-nums[i];
            if(map.containsKey(nums[i])){
                int result[]={map.get(nums[i]),i};
                return result;
            }
            map.put(other,i);
        }
        return new int[2];      
    }
}