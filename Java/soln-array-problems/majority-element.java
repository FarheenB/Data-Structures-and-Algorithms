/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/majority-element/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==1)
            return nums[0];
        
        HashMap<Integer, Integer> map=new HashMap<>();        
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]) && map.get(nums[i])+1>nums.length/2)
                return nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return -1;        
    }
}