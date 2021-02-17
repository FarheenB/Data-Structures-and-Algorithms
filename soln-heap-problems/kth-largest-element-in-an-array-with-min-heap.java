/*
https://leetcode.com/problems/kth-largest-element-in-an-array/
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(k);
        int i=0;
        while(i<nums.length){
            minHeap.offer(nums[i]);
            if(minHeap.size()>k)
                minHeap.poll();
            i++;
        }
        return minHeap.peek();        
    }
}
