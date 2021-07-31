/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/squares-of-a-sorted-array/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int i=0;
        int pos=-1;
        while(i<nums.length && nums[i]<0){
            pos++;
            i++;
        }
        int result[]=new int[nums.length];

        i=pos;
        int j=pos+1;
        int index=0;
        while(i>=0 && j<nums.length){
            if(nums[i]*nums[i]<nums[j]*nums[j]){
                result[index++]=nums[i]*nums[i];
                i--;
            }
            else{
                result[index++]=nums[j]*nums[j];
                j++;
            }           
        }
        
        while(i>=0){
            result[index++]=nums[i]*nums[i];
            i--;
        }
        while(j<nums.length){
            result[index++]=nums[j]*nums[j];
            j++;
        }
        
        return result;
        
    }
}