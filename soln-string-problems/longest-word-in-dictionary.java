/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/longest-word-in-dictionary/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    Set<String> set;
    public String longestWord(String[] words) {
        set = new HashSet<>();
        Arrays.sort(words);
        for(String word : words){
            set.add(word);
        }
        for(String w:words)
            System.out.println(w);
        int maxLen = 0;
        
        String ans = "";
        for(String word : words){
            if(helper(word) && word.length() > maxLen){
                maxLen = word.length();
                ans = word;
            }
        }
        return ans;
    }

    private boolean helper(String word){
        String s = "";
        for(char c : word.toCharArray()){
            s += c;
            if(!set.contains(s)){
                return false;
            }
        }
        return true;
    }
}
