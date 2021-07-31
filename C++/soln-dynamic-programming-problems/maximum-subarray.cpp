/**
 @author Farheen Bano

 Date 15-07-2021
  
 Reference-
 https://leetcode.com/problems/maximum-subarray
*/

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int maxSum=nums[0];
        for(int i=1;i<nums.size();i++){
            nums[i]=max(nums[i],nums[i]+nums[i-1]);
            maxSum=max(maxSum,nums[i]);
            
        }
        return maxSum;
    }
};