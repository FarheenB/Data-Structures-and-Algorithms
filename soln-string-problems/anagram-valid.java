/**
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
 https://leetcode.com/problems/valid-anagram/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
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
