/*
https://www.geeksforgeeks.org/find-number-distinct-palindromic-sub-strings-given-string/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    
    HashSet<String> set=new HashSet<>();
    
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); ++i) {
            // odd-length palindromes, single character center
            getPalindromes(s, i, i);

            // even-length palindromes, consecutive characters center
            getPalindromes(s, i, i + 1);
        }
        return set;
    }

    public void getPalindromes(String str, int left, int right) {
        int count = 0;

        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right))
                break;      
            set.add(str.substring(left,right+1));
            left--;
            right++;
        }
    }
}