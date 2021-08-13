/**
 @author Farheen Bano

 Date 13-08-2021
  
 Reference-
 https://leetcode.com/problems/subsets-ii/
*/

class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        vector<vector<int>> result;
        vector<int> cur;
        generateSubsets(0,nums,cur,result);
        return result;
    }
    
     void generateSubsets(int index, vector<int>& nums, vector<int>& cur, vector<vector<int>>& result){        
        result.push_back(cur);

        for(int i=index;i<nums.size();i++){
            if(i>index && nums[i]==nums[i-1])
                continue;
            cur.push_back(nums[i]);
            generateSubsets(i+1,nums,cur,result);
            cur.pop_back();
        }
    }
};