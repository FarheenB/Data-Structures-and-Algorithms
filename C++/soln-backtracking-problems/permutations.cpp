/**
 @author Farheen Bano
  
 Date 13-08-2021

 References-
 https://www.interviewbit.com/problems/permutations/
 https://leetcode.com/problems/permutations/
*/

class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> cur;
        possiblePermutation(nums,cur,result);
        return result;
    }
    
    void possiblePermutation(vector<int>& nums, vector<int>& cur, vector<vector<int>>& result){        
        if(cur.size()==nums.size())
            result.push_back(cur);
                
        else{
            for(int i=0;i<nums.size();i++){
                if(find(cur.begin(), cur.end(), nums[i]) != cur.end())
                    continue;
                cur.push_back(nums[i]);
                possiblePermutation(nums,cur,result);
                cur.pop_back();
            }
        }
    }
};