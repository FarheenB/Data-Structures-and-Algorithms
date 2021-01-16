/*
https://www.geeksforgeeks.org/coin-change-dp-7/
https://leetcode.com/problems/coin-change/

Note: infinite number of each kind of coin
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {

  public int coinChange(int[] coins, int amount) {
    int max = amount + 1;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, max);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }
}