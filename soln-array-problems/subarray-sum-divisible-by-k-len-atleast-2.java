/*
https://leetcode.com/problems/continuous-subarray-sum
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length==1)
            return false;
   
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int mod=(k==0)?sum:sum%k;
            mod=(mod<0)?mod+k:mod;
            if(map.containsKey(mod)){
                int index=map.get(mod);
                if((i-index)>=2)
                    return true;
            }            
            else
                map.put(mod,i);
        }
        return false;
    }
}