/**
 @author Farheen Bano
  
 Reference-
 https://www.geeksforgeeks.org/maximum-product-subarray-set-3/
 https://leetcode.com/problems/maximum-product-subarray/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) 
            return 0;

        int max = nums[0];
        int min = nums[0];
        int result = max;

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int temp_max = Math.max(n, Math.max(max * n, min * n));
            min = Math.min(n, Math.min(max * n, min * n));

            max = temp_max;

            result = Math.max(max, result);
        }

        return result;
    }
}