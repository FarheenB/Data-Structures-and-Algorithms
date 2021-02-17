/*
https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxInd=new LinkedList<>();
        Deque<Integer> minInd=new LinkedList<>();
        int i=0;
        int j=0;
        int maxLength=Integer.MIN_VALUE;
        
        while(j<nums.length){
            while(!minInd.isEmpty() && nums[minInd.peekLast()]<=nums[j]){
                minInd.pollLast();
            }
            minInd.offerLast(j);
            while(!maxInd.isEmpty() && nums[maxInd.peekLast()]>=nums[j]){
                maxInd.pollLast();
            }
            maxInd.offerLast(j);
            
            if(Math.abs(nums[maxInd.peekFirst()]-nums[minInd.peekFirst()])<=limit){
                maxLength=Math.max(maxLength,j-i+1);
                j++;
            }
            else{
                i++;
                if(i>minInd.peekFirst())
                    minInd.pollFirst();
                if(i>maxInd.peekFirst())
                    maxInd.pollFirst();
            }
        }
        
        return maxLength;
        
    }
}