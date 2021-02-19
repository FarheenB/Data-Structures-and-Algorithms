/*
https://leetcode.com/problems/range-sum-query-immutable/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class NumArray {

    int[] dp;
    public NumArray(int[] nums) {
        dp=new int[nums.length+1];
        for(int i=1;i<=nums.length;i++){
            dp[i]=nums[i-1]+dp[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        return dp[j+1]-dp[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */