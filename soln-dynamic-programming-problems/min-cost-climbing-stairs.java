/*
 @author Farheen Bano
  
 Each time you can either climb 1 or 2 steps. Return the minimum cost to reach the top of the floor.
 
 Reference-
 https://leetcode.com/problems/min-cost-climbing-stairs/

 NOTE: Variation of Fibinacci Series
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2;i<dp.length;i++) {
            dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
        } 
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
}
