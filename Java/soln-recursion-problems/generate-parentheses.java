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
        if(n==0)
           return result;
        solve(n,n,"");
        return result;        
    }
    
    public void solve(int open_br, int close_br, String str){
        if(open_br==0 && close_br==0){
            result.add(str);
            return; 
        }    
        if(open_br!=0)
            solve(open_br-1,close_br,str+"(");

        if(close_br>open_br){
            solve(open_br,close_br-1,str+")");
        }
    }
}
