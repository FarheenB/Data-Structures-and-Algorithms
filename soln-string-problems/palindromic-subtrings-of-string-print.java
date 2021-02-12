import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    List<String> result=new ArrayList<>();
    
    public List<String> getPalindromeSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); ++i) {
            // odd-length palindromes, single character center
            countPalindromes(s, i, i);

            // even-length palindromes, consecutive characters center
            countPalindromes(s, i, i + 1);
        }
        return result;
    }

    public void countPalindromes(String str, int left, int right) {
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right))
                break; 
            String palind_str=str.substring(left,right+1);
            result.add(palind_str);
            
            left--;
            right++;
        }
    }
}