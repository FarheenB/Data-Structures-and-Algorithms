/*
https://www.geeksforgeeks.org/count-palindrome-sub-strings-string/
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
            
            if((right-left)+1>=2){
                count++;
            }
            left--;
            right++;
        }
        return count;
    }
}