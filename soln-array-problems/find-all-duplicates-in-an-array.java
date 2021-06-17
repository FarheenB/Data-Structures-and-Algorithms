/**
 @author Farheen Bano
  
 References-
 https://practice.geeksforgeeks.org/problems/find-duplicates-in-an-array/1
 https://leetcode.com/problems/find-all-duplicates-in-an-array/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result=new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                int x=nums[i]-1;
                if(nums[x]==x+1)
                    continue;
                else{
                    int temp=nums[i];
                    nums[i]=nums[x];
                    nums[x]=temp;
                    i--;
                }                    
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
                result.add(nums[i]);
        }
        return result;
    }
}
