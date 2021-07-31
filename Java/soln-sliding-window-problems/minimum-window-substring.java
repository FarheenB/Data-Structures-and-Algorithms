/**
 @author Farheen Bano
  
 References-
 https://practice.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1
 https://www.interviewbit.com/problems/window-string/
 https://leetcode.com/problems/minimum-window-substring/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public String minWindow(String s, String t) {        
        HashMap<Character, Integer> map=new HashMap<>();
        for(char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        int i=0;
        int j=0;
        int count=map.size();
        int min=Integer.MAX_VALUE;
        String substr="";
        
        while(j<s.length()){
            char ch=s.charAt(j);            
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);            
                if(map.get(ch)==0){
                    count--;
                }
            }
            
            //if a window is found
            if(count==0){
                while(count==0){
                    if(min>(j-i+1)){
                        min=j-i+1;
                        substr=s.substring(i,j+1);
                    }

                    char new_ch=s.charAt(i);
                    if(map.containsKey(new_ch)){
                        map.put(new_ch,map.get(new_ch)+1);
                        if(map.get(new_ch)==1)
                            count++;
                    }
                    i++;
                }
            }
            j++;
        }
        return substr;
    }
}
