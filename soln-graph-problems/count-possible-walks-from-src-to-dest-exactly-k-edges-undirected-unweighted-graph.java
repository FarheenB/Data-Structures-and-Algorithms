/**
 @author Farheen Bano
  
 Reference-
 https://practice.geeksforgeeks.org/problems/possible-paths3834/1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public int MinimumWalk(int[][] graph, int u, int v, int k){
        int V=graph.length;
        int dp[][][] = new int[V][V][k + 1];
        
        for (int e = 0; e <= k; e++) {
            for (int i = 0; i < V; i++){
                for (int j = 0; j < V; j++){
                    if (e == 0 && i == j)
                        dp[i][j][e] = 1;
                    if (e == 1 && graph[i][j] != 0)
                        dp[i][j][e] = 1;

                    if (e > 1) {
                        for (int a = 0; a < V; a++)
                            if (graph[i][a] != 0)
                                dp[i][j][e] += dp[a][j][e - 1];
                    }
                }
            }
        }
        return dp[u][v][k];
    }
}
