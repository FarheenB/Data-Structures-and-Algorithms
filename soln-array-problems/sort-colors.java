/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/sort-colors/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public void sortColors(int[] nums) {
        int red_count=0;
        int white_count=0;
        int blue_count=0;

        for(int n:nums){
            if(n==0)
                red_count++;
            else if(n==1)
                white_count++;
            else
                blue_count++;
        }
        
        int i=0;
        while(red_count>0){
            nums[i++]=0;
            red_count--;
        }
        while(white_count>0){
            nums[i++]=1;
            white_count--;
        }
        while(blue_count>0){
            nums[i++]=2;
            blue_count--;
        }
    }
}