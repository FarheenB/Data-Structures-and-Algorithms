/**
 @author Farheen Bano

 Date 15-07-2021
  
 References-
 https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
 https://leetcode.com/problems/group-anagrams/
*/

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> result; 
        if (strs.size() == 0) 
            return result;
        
        unordered_map<string, vector<string>> anagrams;
        for (string s : strs) {
            string copy_s=s;
            sort(s.begin(),s.end());
            anagrams[s].push_back(copy_s);
        }
    
        for(auto x:anagrams)
            result.push_back(x.second);

        return result;
    }
};