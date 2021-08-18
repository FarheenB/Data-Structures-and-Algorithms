/**
 @author Farheen Bano
  
 Date 13-08-2021
 
 Reference-
 https://leetcode.com/problems/combination-sum-ii/
*/

class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> result;
        vector<int> cur;
        sort(candidates.begin(),candidates.end());
        generateSubsets(0,candidates,cur,result,target);
        return result;
    }
    
    void generateSubsets(int index, vector<int>& candidates, vector<int>& cur, vector<vector<int>>& result, int target){ 
        if(target==0){
            result.push_back(cur);
            return;
        }

        if(target<0)
            return;
        
        for(int i=index;i<candidates.size();i++){
            if(i>index && candidates[i]==candidates[i-1])
                continue;
            cur.push_back(candidates[i]);
            generateSubsets(i+1,candidates,cur,result,target-candidates[i]);
            cur.pop_back();
        }
    }
};