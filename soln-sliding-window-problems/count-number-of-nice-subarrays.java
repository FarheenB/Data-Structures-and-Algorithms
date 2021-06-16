/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/count-number-of-nice-subarrays/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int i=0;
        int j=0;
        int count_odds=0;
        int count=0;
        int res=0;
        while(j<nums.length){
            if(nums[j]%2!=0)
                count_odds++;
            
            if(count_odds>k){
                count=0;
                i++;
                count_odds--;
            }
         
            while(nums[i]%2==0 && i<j){
                count++;
                i++;     
            }   
            
            if(count_odds==k)
                res+=count+1;
            j++;
        }
        return res;
    }
}
