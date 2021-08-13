/**
 @author Farheen Bano
  
 Date 13-08-2021

 References-
 https://www.interviewbit.com/problems/all-unique-permutations/
 https://leetcode.com/problems/permutations-ii/
*/

class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> cur;
        
        unordered_map<int,int> counter;
        for(int num:nums)
            counter[num]++;    
        
        possiblePermutation(nums,cur,counter,result);
        return result;
    }    
    
     void possiblePermutation(vector<int>& nums, vector<int>& cur, unordered_map<int,int> counter, vector<vector<int>>& result){
        if(cur.size()==nums.size())
            result.push_back(cur);
        
        else{
            for(auto& element:counter) {
                if(counter[element.first]>0) {
                    counter[element.first]--;
                    cur.push_back(element.first);
                    possiblePermutation(nums,cur,counter,result);
                    cur.pop_back();
                    counter[element.first]++;
                }
            }
        }
    }
};