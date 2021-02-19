/*
https://leetcode.com/problems/sliding-window-median/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    PriorityQueue<Double> minHeap=new PriorityQueue<>();
    PriorityQueue<Double> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result=new double[nums.length-(k-1)];        
        int i=0;
        int j=0; 
        int index=0;
        while(j<nums.length){
            double push_n=(double)nums[j];
            
            maxHeap.offer(push_n);
            minHeap.offer(maxHeap.poll()); 
            
            if(j-i+1==k){
                result[index++]=median();
                
                double pop_n=(double)nums[i];
                if(maxHeap.contains(pop_n))
                    maxHeap.remove(pop_n);               
                else
                    minHeap.remove(pop_n);
                i++;
            }       
            j++;          
        }
        return result;
    }
    
    double median(){
        while (maxHeap.size() - minHeap.size() >= 2) 
            minHeap.offer(maxHeap.poll());
        while (minHeap.size() - maxHeap.size() >= 1) 
            maxHeap.offer(minHeap.poll());
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }
}