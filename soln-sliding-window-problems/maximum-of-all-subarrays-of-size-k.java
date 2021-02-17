/*
https://www.interviewbit.com/problems/sliding-window-maximum/
https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
https://leetcode.com/problems/sliding-window-maximum/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> result=new ArrayList<>();
        Deque<Integer> max_queue=new LinkedList<>();
        
        int i=0;
        int j=0;
        while(j<nums.length){
            while(!max_queue.isEmpty() && max_queue.peekLast()<nums[j])
                max_queue.pollLast();
            max_queue.offerLast(nums[j]);                   
            
            if((j-i+1)==k){
                int max=max_queue.peekFirst();
                result.add(max);
                if(max==nums[i]){
                    max_queue.pollFirst();
                }
                i++;               
            }
            j++;
        }
        
        int[] max_arr=new int[result.size()];
        for(i=0;i<result.size();i++){
            max_arr[i]=result.get(i);
        }
        return max_arr;
    }
}