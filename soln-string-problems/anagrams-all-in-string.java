/*
https://leetcode.com/problems/find-all-anagrams-in-a-string/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length()<p.length())
            return new ArrayList<>();
        List<Integer> indices=new ArrayList<>();

        if(s.length()==p.length()){
            if(isAnagram(s,p)){
                indices.add(0);
            }
            return indices;            
        }
        for(int i=0;i<=(s.length()-p.length());i++){
            String substring_s=s.substring(i,p.length()+i);
            if(isAnagram(substring_s,p)){
                indices.add(i);
            }
        }
        return indices;        
    }
    
     public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int counts[]=new int[26];
        
        for(int i=0;i<s.length();i++){
            counts[s.charAt(i)-'a']++;
            counts[t.charAt(i)-'a']--;
        }
        
        for(int i: counts){
            if(i!=0)
                return false;
        }
        return true;
        
    }
}