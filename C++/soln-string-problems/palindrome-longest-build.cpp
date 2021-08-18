/**
 @author Farheen Bano
  
 Date 16-07-2021

 Reference-
 https://leetcode.com/problems/longest-palindrome/
*/

class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char,int> map;
        
        for(char ch:s)
            map[ch]++;
        
        int flag=0;
        for(auto element:map){
            if(element.second%2!=0){
                flag++;
            }
        }
        return flag>0?s.size()-flag+1:s.size();
    }
};