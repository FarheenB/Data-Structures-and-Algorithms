/*
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/array-nesting/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public int arrayNesting(int[] nums) {
        int maxcount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                int start = nums[i], count = 0;
                
                while (nums[start] != Integer.MAX_VALUE) {
                    int temp = start;
                    start = nums[start];
                    count++;
                    nums[temp] = Integer.MAX_VALUE;
                }
                maxcount = Math.max(maxcount, count);
            }
        }
        return maxcount;
    }
}
