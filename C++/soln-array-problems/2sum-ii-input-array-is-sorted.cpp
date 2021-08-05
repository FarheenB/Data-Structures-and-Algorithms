/**
 @author Farheen Bano

 Date 05-08-2021
  
 Reference-
 https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
*/

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        if(nums.size()<2)
            return {};
        int left=0;
        int right=nums.size()-1;
        while(left>=0 && right<nums.size() && left<right){
            int sum=nums[left]+nums[right];
            if(sum<target)
                left++;
            else if(sum>target)
                right--;
            else
                return {left+1,right+1};
        }
        return {};      
    }
};