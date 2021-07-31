/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/letter-case-permutation/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    List<String> result=new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        if(S.length()==0){
           return result;
        }        
        solve(S,0,"");
        return result;        
    }
    
    public void solve(String str, int index,String curr){
        if(index==str.length()){
            result.add(curr);
            return;
        }
        if(Character.isLetter(str.charAt(index))){
            solve(str,index+1,curr+Character.toUpperCase(str.charAt(index)));
            solve(str,index+1,curr+Character.toLowerCase(str.charAt(index)));
        }
        else{
            solve(str,index+1,curr+str.charAt(index));
        }
    }
}
