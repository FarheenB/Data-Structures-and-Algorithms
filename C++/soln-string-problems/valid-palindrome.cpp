/**
 @author Farheen Bano

 Date 15-07-2021
  
 Reference-
 https://leetcode.com/problems/valid-palindrome/
*/

class Solution {
public:
    bool isPalindrome(string s) {
        transform(s.begin(),s.end(),s.begin(), ::tolower);
        s.erase(remove(s.begin(),s.end(),' '),s.end());
        int len=s.size();
        int left=0;
        int right=len-1;
        
        while(left<right){
            if(s[left]==s[right])
            {
                left++;
                right--;
            }
            else{
                if((s[left]<'a' || s[left]>'z') && (s[left]<'0' || s[left]>'9'))
                    left++;
                else if((s[right]<'a' || s[right]>'z') && (s[right]<'0' || s[right]>'9'))
                    right--;
                else
                    return false;
            }
                
        }
        return true;
    }
};