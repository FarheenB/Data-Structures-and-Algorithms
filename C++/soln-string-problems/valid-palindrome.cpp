/**
 @author Farheen Bano

 Date 15-07-2021
  
 Reference-
 https://leetcode.com/problems/valid-palindrome/
*/

class Solution {
public:
    bool isPalindrome(string s) {
        int len=s.size();
        int left=0;
        int right=len-1;
        
        while(left<right){
            if(!isalnum(s[left]))
                left++;
            else if(!isalnum(s[right]))
                right--;
            else if(tolower(s[left])!=tolower(s[right]))
                return false;
            else
            {
                left++;
                right--;
            }              
        }
        return true;
    }
};