/*
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/contiguous-array/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int count=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            count=count+(nums[i]==1?1:-1);
            if(map.containsKey(count)){
                //number of 0's and 1's are equal between these indices corresponding to equal counts
                max=Math.max(max,i-map.get(count));
            }
            else
                map.put(count,i);
        }
        return max;
    }
}
