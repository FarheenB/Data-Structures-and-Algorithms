/**
 @author Farheen Bano
  
 References-
 https://practice.geeksforgeeks.org/problems/sub-array-sum-divisible-by-k2617/1
 https://leetcode.com/problems/subarray-sums-divisible-by-k/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {    
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int mod=(k==0)?sum:sum%k;
            mod=(mod<0)?mod+k:mod;
            if(map.containsKey(mod))
                count+=map.get(mod);    
            map.put(mod,map.getOrDefault(mod,0)+1);
        }
        return count;        
    }
}