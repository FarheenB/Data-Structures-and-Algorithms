/**
 @author Farheen Bano
  
 Date 19-07-2021
 
 Reference-
 https://leetcode.com/problems/sort-characters-by-frequency/
*/

class Solution {
public:
    string frequencySort(string s) {
        unordered_map<char,int> counts;
        for(char ch:s)
            counts[ch]+=1;
        
        //Create a vector for all the entries of this map from begin till end 
        vector<pair<char,int>> count_vectors(counts.begin(),counts.end());
        sort(count_vectors.begin(),count_vectors.end(),
            [](pair<char,int>& p1, pair<char,int>& p2){
                return p1.second>p2.second;
            });
            
        // adding the comparator
        string result="";
        for(pair<char,int> p:count_vectors){
            for(int i=0;i<p.second;++i)
                result+=p.first;
        }
        return result;
    }
};
