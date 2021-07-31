/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/stone-game/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean stoneGame(int[] piles) {
        int N = piles.length;

        int[][] dp = new int[N+2][N+2];
        for (int a = 1; a <= N; ++a)
            for (int i = 0; i + a <= N; ++i) {
                int j = i + a - 1;
                int choose = (j + i + N) % 2;  
                if (choose == 1)
                    dp[i+1][j+1] = Math.max(piles[i] + dp[i+2][j+1], piles[j] + dp[i+1][j]);
                else
                    dp[i+1][j+1] = Math.min(-piles[i] + dp[i+2][j+1], -piles[j] + dp[i+1][j]);
            }

        return dp[1][N] > 0;
    }
}
