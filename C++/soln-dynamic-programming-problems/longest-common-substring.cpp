/**
 @author Farheen Bano
  
 Date 14-08-2021
  
 Reference-
 https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1

 NOTE: Variation of Longest Common Subsequence
*/ 

//------------------------------------------------------------------------------
//Tabulation Approach

class Solution{
    public:
    
    int longestCommonSubstr (string S1, string S2, int n, int m)
    {
        int dp[n+1][m+1];
        int max_len=0;
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
                else if(S1[i-1]==S2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                    max_len=max(max_len,dp[i][j]);
                }
                else
                    dp[i][j]=0;
            }
        }
        return max_len;
    }
};