/**
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/find-palindromic-sub-strings-given-string-set-2/
 https://leetcode.com/problems/palindromic-substrings/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); ++i) {
            // odd-length palindromes, single character center
            count += countPalindromes(s, i, i);

            // even-length palindromes, consecutive characters center
            count += countPalindromes(s, i, i + 1);
        }
        return count;
    }

    public int countPalindromes(String str, int left, int right) {
        int count = 0;

        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right))
                break;      
            left--;
            right++;

            count++;
        }
        return count;
    }
}
