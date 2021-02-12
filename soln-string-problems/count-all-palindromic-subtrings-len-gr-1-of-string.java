/*
https://practice.geeksforgeeks.org/problems/count-palindrome-sub-strings-of-a-string/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static int countPalindromesSubstrs(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); ++i) {
            // odd-length palindromes, single character center
            count += countPalindromes(s, i, i);

            // even-length palindromes, consecutive characters center
            count += countPalindromes(s, i, i + 1);
        }
        return count;
    }

    public static int countPalindromes(String str, int left, int right) {
        int count = 0;

        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right))
                break;      
                
            if(right-left+1>1){
                count++;    
            }            
            left--;
            right++;
        }
        return count;
    }
}