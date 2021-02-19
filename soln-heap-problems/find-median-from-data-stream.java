/*
https://leetcode.com/problems/find-median-from-data-stream/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class MedianFinder {
    PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    
    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {       
        if(maxHeap.isEmpty() || maxHeap.peek()>num)
            maxHeap.offer(num);
        else
            minHeap.offer(num);

        if(maxHeap.size()-minHeap.size()>1){
            minHeap.offer(maxHeap.poll()); 
        }
        else if(minHeap.size()-maxHeap.size()>1){
            maxHeap.offer(minHeap.poll()); 
        }
    }
    
    public double findMedian() {
        if (minHeap.size() == maxHeap.size())
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        if(minHeap.size()>maxHeap.size())
            return minHeap.peek();
        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */