/**
 @author Farheen Bano
  
 Reference-
 https://www.geeksforgeeks.org/wildcard-pattern-matching/
 https://leetcode.com/problems/wildcard-matching/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();

        int ind = 0;
        boolean isFirst = true;
        for ( int i = 0 ; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[ind++] = pattern[i];
                    isFirst = false;
                }
            } 
            else {
                pattern[ind++] = pattern[i];
                isFirst = true;
            }
        }

        boolean dp[][] = new boolean[str.length + 1][ind + 1];

        if (ind > 0 && pattern[0] == '*') {
            dp[0][1] = true;
        }

        dp[0][0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (pattern[j-1] == '?' || str[i-1] == pattern[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } 
                else if (pattern[j-1] == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[str.length][ind];
    }
}
