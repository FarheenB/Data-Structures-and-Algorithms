/*
https://leetcode.com/problems/contains-duplicate-ii/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]) && Math.abs(map.get(nums[i])-i)<=k){
                return true;
            }
            else
                map.put(nums[i],i);
        }
        return false;
        
    }
}