/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/jump-game-v/
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    public int maxJumps(int[] arr, int d) {
        int[] dp = new int[arr.length];
        int max = 1;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, dfs(arr, i, d, dp));
        }
        return max;
    }
    
    private int dfs(int[] arr, int i, int d, int[] dp) {
        if (dp[i] != 0) {
            return dp[i];
        }
        int max = 1;
        for (int j = i + 1; j <= Math.min(i + d, arr.length - 1) && arr[j] < arr[i]; ++j)         {
            max = Math.max(max, 1 + dfs(arr, j, d, dp));
        }
        for (int j = i - 1; j >= Math.max(i - d, 0) && arr[j] < arr[i]; --j) {
            max = Math.max(max, 1 + dfs(arr, j, d, dp));
        }
        dp[i] = max;
        return dp[i];
    }
}