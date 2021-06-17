/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/find-the-duplicate-number/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int findDuplicate(int[] nums) {        
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=(i+1)){
                int x=nums[i]-1;
                if(nums[x]==x+1)
                    return nums[i];
                else{
                    int temp=nums[x];
                    nums[x]=nums[i];
                    nums[i]=temp; 
                    i--;
                }
            }
        }    
        return nums[nums.length-1];
    }
}
