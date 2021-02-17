/*
https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int longestSubstring(String s, int k) {
        HashMap<Character, Integer> map=new HashMap<>();        
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        boolean isValid=true;
        int j=0;
        int start=0;
        int maxLen=0;
        
        while(j<s.length()){
            char ch=s.charAt(j);
            if(map.get(ch)>0 && map.get(ch)<k){
                maxLen=Math.max(maxLen,longestSubstring(s.substring(start,j),k));
                start=j+1;
                isValid=false;
            } 
            j++;
        }
        if(isValid)
            return s.length();
        return Math.max(maxLen,longestSubstring(s.substring(start),k));
    }
}