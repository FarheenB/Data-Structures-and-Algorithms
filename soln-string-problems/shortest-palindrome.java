/*
https://leetcode.com/problems/shortest-palindrome
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    int max_length=0;
    String max_palind_str="";
    int lastIndx=0;
    
    public String shortestPalindrome(String s) {
        
        if(s==null || s=="" || s.length()<2)
            return s;
        
        for(int i=s.length()-1;i>=0;i--){
            if(getPalindrome(s,0,i))
            {
                StringBuffer newStr=new StringBuffer(s.substring(i+1));
        
                return newStr.reverse().toString()+""+s;
            }
        }
        return s;
    }
    
    public boolean getPalindrome(String s, int left, int right){
       while (s.charAt(left) == s.charAt(right) && left < right) {
            left++;
            right--;
        }

        return left >= right;
    }
}