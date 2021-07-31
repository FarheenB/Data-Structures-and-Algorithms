/**
 @author Farheen Bano
  
 Date 19-07-2021
 
 Reference-
 https://leetcode.com/problems/kth-largest-element-in-an-array/
*/

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> minHeap;
        int i=0;
        while(i<nums.size()){
            minHeap.push(nums[i]);
            if(minHeap.size()>k)
                minHeap.pop();
            i++;
        }
        return minHeap.top();
    }
};