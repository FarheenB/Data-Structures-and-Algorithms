/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/generate-parentheses/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    List<String> result=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n==0){
           return result;
        }        
        solve(n,n,"");
        return result;        
    }
    
    public void solve(int open, int close, String str){
        if(open==0 && close==0){
            result.add(str);
            return; 
        }    
        if(open!=0){
            solve(open-1,close,str+"(");
        }
        if(close>open){
            solve(open,close-1,str+")");
        }
    }
}
