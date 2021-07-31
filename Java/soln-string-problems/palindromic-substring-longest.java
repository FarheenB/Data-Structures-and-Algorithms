/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/longest-palindromic-substring
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    int max_length=0;
    String max_palind_str="";
    
    public String longestPalindrome(String s) {
        if(s==null || s=="" || s.length()==0)
            return s;
        
        for(int i=0;i<s.length();i++){
            getPalindrome(s,i,i);
            getPalindrome(s,i,i+1);
        }
        
        return max_palind_str;
    }
    
    public void getPalindrome(String s, int left, int right){
        while(left>=0 && right<s.length()){
            if(s.charAt(left)!=s.charAt(right))
                break;
            
            if(max_length<right-left+1){
                max_length=right-left+1;
                max_palind_str=s.substring(left,right+1);
            }
                
            left--;
            right++;
        }
    }
}
