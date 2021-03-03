/*
https://www.geeksforgeeks.org/shortest-path-exactly-k-edges-directed-weighted-graph/
*/

class Solution {
    public int shortestPathKedges(int n, int[][] graph, int src, int dst, int K) {
        int[][][] dp=new int[n][n][K];
        
        for(int e=0;e<K+2;e++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dp[i][j][e]=Integer.MAX_VALUE;
                    
                    if(e==0 && i==j)
                        dp[i][j][e]=0;
                    if(e==1 && graph[i][j]!=0)
                        dp[i][j][e]=graph[i][j];
                    if(e>1){
                        for(int adj_node=0;adj_node<n;adj_node++){
                            if(graph[i][adj_node]!=Integer.MAX_VALUE && dp[adj_node][j][e-1]!=Integer.MAX_VALUE && i!=adj_node && j!=adj_node)
                                dp[i][j][e]=Math.min(dp[i][j][e],graph[i][adj_node]+dp[adj_node][j][e-1]);
                        }
                    }
                        
                }
            }
        }
        return dp[src][dst][K];
    }
}