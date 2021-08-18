/**
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/find-palindromic-sub-strings-given-string-set-2/
 https://leetcode.com/problems/palindromic-substrings/
*/

class Solution {
public:
    int countSubstrings(string s) {
        int count = 0;

        for (int i = 0; i < s.size(); ++i) {
            // odd-length palindromes, single character center
            count += countPalindromes(s, i, i);

            // even-length palindromes, consecutive characters center
            count += countPalindromes(s, i, i + 1);
        }
        return count;
    }

    int countPalindromes(string str, int left, int right) {
        int count = 0;

        while (left >= 0 && right < str.size()) {
            if (str[left] != str[right])
                break;      
            left--;
            right++;

            count++;
        }
        return count;
    }
};