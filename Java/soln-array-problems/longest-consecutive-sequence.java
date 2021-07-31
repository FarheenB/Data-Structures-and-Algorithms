/**
 @author Farheen Bano
  
 References-
 https://www.interviewbit.com/problems/longest-consecutive-sequence/
 https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1
 https://leetcode.com/problems/longest-consecutive-sequence
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> num_set=new HashSet<>();
        for(int n:nums){
            num_set.add(n);
        }
        
        int count=1;
        int max_count=Integer.MIN_VALUE;
        for(int n:num_set){
            if(!num_set.contains(n-1)){
                count=1;           
                int cur_n=n;
                while(num_set.contains(cur_n+1)){
                    cur_n+=1;
                    count++;
                }
                max_count=Math.max(max_count,count);
            }
        }
        return max_count==Integer.MIN_VALUE?0:max_count;
    }
}