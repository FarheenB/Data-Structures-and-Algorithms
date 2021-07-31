/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/kth-largest-element-in-a-stream
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class KthLargest {
    
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        minHeap=new PriorityQueue<>();
        this.k=k; 
        for(int i:nums){
            minHeap.add(i);
            if(minHeap.size()>k) {
                minHeap.remove();
            }
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
 		if(minHeap.size()>this.k) {
			minHeap.remove();
		}
        //minHeap containing k largest elements 
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
