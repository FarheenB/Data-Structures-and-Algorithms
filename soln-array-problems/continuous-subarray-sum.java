/*
https://leetcode.com/problems/continuous-subarray-sum/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            int sum=0;
            int count=0;
            for(int j=i;j<nums.length;j++)
            {
                count++;
                sum+=nums[j];
                if(k!=0 && sum%k==0 && count>=2)
                    return true;
                else if(k==0 && sum==0 && count>=2)
                    return true;
            }
        }
        return false;
    }
}