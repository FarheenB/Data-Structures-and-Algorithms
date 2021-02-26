/*
https://www.interviewbit.com/problems/different-bits-sum-pairwise/
https://leetcode.com/problems/total-hamming-distance/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int totalHammingDistance(int[] nums) {
        int total_dist=0;
        for(int i=0;i<32;i++){
            //count bits for each position
            int count_ones=0;
            for(int num:nums){
                count_ones+=(num>>i) & 1;       
            }
            //product of number of ones and zeroes
            total_dist+=count_ones*(nums.length-count_ones);
        }
        return total_dist;
    }    
}