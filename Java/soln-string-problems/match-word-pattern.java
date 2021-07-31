/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/word-pattern/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] pattern_char=pattern.toCharArray();
        String[] str=s.trim().split(" ");
        HashSet<Character> pattern_set=new HashSet<>();
        HashSet<String> str_set=new HashSet<>();
        
        for(char ch:pattern_char){
            pattern_set.add(ch);
        }
        for(String st:str){
            str_set.add(st);
        }
        if(pattern_set.size()!=str_set.size()){
            return false;
        }

        if(pattern.length()!=str.length)
            return false;

        HashMap<Character,String> map=new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(pattern_char[i]) && !map.get(pattern_char[i]).equals(str[i]))
                return false;
            else{
                map.put(pattern_char[i],str[i]);
            }
        }
        return true;         
    }
}
