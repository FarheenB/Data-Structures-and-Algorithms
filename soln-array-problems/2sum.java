/*
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/two-sum/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> second=new HashMap<Integer,Integer>();
        int result[]=new int[2];
        int other;
        for(int i=0;i<nums.length;i++) {
            other=target-nums[i];
            if(second.containsKey(nums[i])) {
                result[0]=second.get(nums[i]);
                result[1]=i;
                return result;
            }
            second.put(other,i);
        }
        return result;      
    }
}
