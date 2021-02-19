/*
https://www.geeksforgeeks.org/number-subarrays-sum-exactly-equal-k/
https://leetcode.com/problems/subarray-sum-equals-k/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k))
                count+=map.get(sum-k);    
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;        
    }
}