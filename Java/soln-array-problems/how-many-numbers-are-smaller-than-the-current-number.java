/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] freq = new int[101];

        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        int sum = 0;

        for (int i = 0; i < freq.length; i++) {
            int temp = freq[i];                
            freq[i] = sum;
            sum = sum + temp;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = freq[nums[i]];
        }

        return nums;
    }
}
