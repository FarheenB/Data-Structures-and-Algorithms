/**
 @author Farheen Bano

 Date 13-08-2021
  
 Reference-
 https://leetcode.com/problems/combinations/
*/

class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
         vector<vector<int>> result;
        vector<int> cur;
        possibleCombination(n,1,k,cur,result);
        return result;
    }    
    
    void possibleCombination(int n, int start, int remaining, vector<int>& cur, vector<vector<int>>& result){
        if(remaining==0)
            result.push_back(cur);
        
        else{
            for(int i=start;i<=n-remaining+1;i++){
                if(find(cur.begin(),cur.end(),i)!=cur.end())
                    continue;
                cur.push_back(i);
                possibleCombination(n,i+1,remaining-1,cur,result);
                cur.pop_back();
            }
        }
    }    
};