/**
 @author Farheen Bano

 Date 05-08-2021
  
 Reference-
 https://leetcode.com/problems/two-sum/
*/

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        if(nums.size()<2)
            return {};
        unordered_map<int,int> map;
        for(int i=0;i<nums.size();i++){
            int other=target-nums[i];
            if(map.find(nums[i])!= map.end())
                return {map[nums[i]],i};
            map[other]=i;
        }
        return {};
    }
};