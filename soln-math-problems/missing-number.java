/*
https://leetcode.com/problems/missing-number/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum_natural=n*(n+1)/2;
        int sum_given=0;
        for(int i:nums){
            sum_given+=i;
        }
        return sum_natural-sum_given;
    }
}