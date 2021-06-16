/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/longest-palindrome/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        char[] char_s=s.toCharArray();
        
        for(char ch:char_s){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        int flag=0;
        for(char key:map.keySet()){
            if(map.get(key)%2!=0){
                flag++;
            }
        }
        return flag>0?s.length()-flag+1:s.length();
    }
}
