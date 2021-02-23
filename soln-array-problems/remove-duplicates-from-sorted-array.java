/*
https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array/
https://leetcode.com/problems/remove-duplicates-from-sorted-array
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        for(int j=i+1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            } 
        }
        return i+1;
    }
}