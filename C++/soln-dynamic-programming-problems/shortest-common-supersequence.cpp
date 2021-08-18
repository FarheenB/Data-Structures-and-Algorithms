/**
 @author Farheen Bano
  
 Date 14-08-2021

 Reference-
 https://www.geeksforgeeks.org/shortest-common-supersequence/
 
 NOTE: Variation of Longest Common Subsequence
*/ 


//------------------------------------------------------------------------------
//Tabulation Approach

class Solution
{
    public:
    //Function to find length of shortest common supersequence of two strings.
    int shortestCommonSupersequence(string X, string Y, int m, int n){
        return n+m-lcs(m,n,X,Y);
    }
    
    int lcs(int x, int y, string s1, string s2)
    {
       int dp[x+1][y+1];

        for(int i=0;i<=x;i++){
            for(int j=0;j<=y;j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
                else if(s1[i-1]==s2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else 
                    dp[i][j]=max(dp[i][j-1],dp[i-1][j]);
            }
        }        
        return dp[x][y];
    }
};