/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/palindrome-permutation/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean canPermutePalindrome(String s) {
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
        
        if(flag>1)
            return false;
        return true;
    }
}
