/*
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/missing-number/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int missingNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                continue;
            if(nums[i]!=(i+1)){
                int x=nums[i]-1;
                if(nums[x]==x+1)
                    continue;
                else{
                    int temp=nums[x];
                    nums[x]=nums[i];
                    nums[i]=temp; 
                    i--;
                }
            }
        }    
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                return i+1;
        }
        return 0;
    }
}
