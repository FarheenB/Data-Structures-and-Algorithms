/**
 @author Farheen Bano
  
 Date 13-08-2021

 Reference-
 https://leetcode.com/problems/generate-parentheses/
*/

class Solution {
public:
    vector<string> result;
    
    vector<string> generateParenthesis(int n) {
        if(n==0)
           return result;        
        solve(n,n,"");
        return result;        
    }
    
    void solve(int open_br, int close_br, string str){
        if(open_br==0 && close_br==0){
            result.push_back(str);
            return; 
        }    
        if(open_br!=0)
            solve(open_br-1,close_br,str+"(");
        
        if(close_br>open_br)
            solve(open_br,close_br-1,str+")");
    }
};