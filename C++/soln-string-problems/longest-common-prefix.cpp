/**
 @author Farheen Bano
  
 Date 11-08-2021
  
 Reference-
 https://leetcode.com/problems/longest-common-prefix/
*/

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if(strs.size()==0)
            return "";
        if(strs.size()==1)
            return strs[0];
        
        string first_word=strs[0];
        string prefix="";

        for(int i=0;i<first_word.size();i++){
            for(int j=1;j<strs.size();j++)
                if(i>=strs[j].size() || first_word[i]!=strs[j][i]){
                    return prefix;
            }
            prefix=prefix+""+first_word[i];            
        }
        return prefix;
    }
};  