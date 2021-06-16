/**
 @author Farheen Bano
  
 Reference-
 https://www.geeksforgeeks.org/permute-string-changing-case/
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
        solve(str,index+1,curr+Character.toUpperCase(str.charAt(index)));
        solve(str,index+1,curr+Character.toLowerCase(str.charAt(index)));
    }
}
