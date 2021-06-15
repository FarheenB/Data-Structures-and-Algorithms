/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/shortest-distance-to-a-character/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++)
            dp[i] = S.charAt(i) == C ? 0 : n;

        //left scanning
        for (int i = 1; i < n; i++)
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        
        //right scanning
        for (int i = n - 2; i >= 0; i--)
            dp[i] = Math.min(dp[i], dp[i + 1] + 1);
        
        return dp;
    }
}
