/*
https://www.geeksforgeeks.org/check-if-a-string-is-a-scrambled-form-of-another-string/
https://leetcode.com/problems/scramble-string/

NOTE: Variation of Matrix Chain Multiplicaton Problem
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    HashMap<String, Boolean> map;        
    public boolean isScramble(String s1, String s2) {      
            map = new HashMap();
            return solve(s1,s2);
    }
    
    boolean solve(String s1, String s2){
        if(s1.compareTo(s2)==0)
            return true;
        if(s1.length()<=1)
            return false;
        
        String temp=s1+" "+s2;
        
        if(map.containsKey(temp))
                return map.get(temp);
        
        int n=s1.length();
                
        boolean flag = false;
        
        for( int k = 0; k < n-1; k++ ){
            flag = (solve(s1.substring(0, k+1), s2.substring(0, k+1)) && 
                    solve(s1.substring(k+1, n), s2.substring(k+1, n))) || 
                   (solve(s1.substring(0, k+1), s2.substring(n-(k+1), n)) && 
                    solve(s1.substring( k+1, n), s2.substring( 0, n-(k+1))));
            
            if(flag)
               break;    
        }
        map.put(s1+" "+s2, flag);
        return flag;        
    }
}