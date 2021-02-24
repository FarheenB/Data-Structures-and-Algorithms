/*
https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array/
https://leetcode.com/problems/remove-duplicates-from-sorted-array
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        int j=0;
        for(int i=j+1;i<nums.length;i++){
            if(nums[j]!=nums[i]){
                j++;
                nums[j]=nums[i];
            } 
        }
        return j+1;
    }
}