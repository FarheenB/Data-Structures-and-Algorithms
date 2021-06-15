/*
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/circular-array-loop/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {    
    public boolean circularArrayLoop(int[] nums) {
        int n=nums.length;
        for (int i = 0;i<n;i++){
            int fast,slow;
            slow = fast = i;
            boolean forward = nums[i] > 0;
            
            while(true){
                slow = getNextIndex(nums, n, slow, forward);
                if (slow == -1)
                    break;
                
                fast = getNextIndex(nums, n, fast, forward);
                if (fast == -1)
                    break;
                fast = getNextIndex(nums, n, fast, forward);
                if (fast == -1)
                    break;

                if (slow == fast)
                    return true;
            }
       } 
       return false;
   }
    
    public int getNextIndex(int[] nums, int n, int index, boolean forward){
        boolean direction = nums[index] >= 0;
        
        if (direction != forward)
            return -1;
        
        int nextIndex = (index + nums[index]) % n;
        
        if (nextIndex < 0)
            nextIndex = nextIndex + n;
        
        if (nextIndex == index)
            return -1;
        
        return nextIndex;
    }
}
