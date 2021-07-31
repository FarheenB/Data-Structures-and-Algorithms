/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/letter-combinations-of-a-phone-number
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    List<String> result=new ArrayList<>();

    public List<String> letterCombinations(String digits) {        
        if(digits==null || digits.length()==0)
            return result;
        
        String[] mapping={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};        
        solve(digits,"",0,mapping);
        return result;    
    }
    
    public void solve(String digits, String current, int index, String[] mapping){
        if(index==digits.length()){
            result.add(current);
            return;
        }
        
        String letters=mapping[digits.charAt(index)-'0'];
        for(char ch:letters.toCharArray()){
            solve(digits,current+ch,index+1,mapping);            
        }
    }
}
