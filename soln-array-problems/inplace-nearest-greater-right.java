/*
https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] replaceElements(int[] nums) {
        int maxRight=-1;
        int prev=nums[nums.length-1];
        nums[nums.length-1]=maxRight;
        for(int i=nums.length-2;i>=0;i--){
            maxRight=Math.max(maxRight,prev);
            prev=nums[i];
            nums[i]=maxRight;
        }
        return nums;
    }
}