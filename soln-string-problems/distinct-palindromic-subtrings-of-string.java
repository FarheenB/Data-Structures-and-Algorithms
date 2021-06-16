/**
 @author Farheen Bano
  
 Reference-
 https://practice.geeksforgeeks.org/problems/distinct-palindromic-substrings/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    
    HashSet<String> set=new HashSet<>();
    
    public int countPalindromeSubstrs(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); ++i) {
            // odd-length palindromes, single character center
            getPalindromes(s, i, i);

            // even-length palindromes, consecutive characters center
            getPalindromes(s, i, i + 1);
        }
        return set.size();
    }

    public void getPalindromes(String str, int left, int right) {
        int count = 0;

        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right))
                break;   
                
            String palind_str=str.substring(left,right+1);
            if(!set.contains(palind_str)){
                set.add(palind_str);
            }
            
            left--;
            right++;
        }
    }
}
