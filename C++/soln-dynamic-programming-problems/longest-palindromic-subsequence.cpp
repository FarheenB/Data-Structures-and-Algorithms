/**
 @author Farheen Bano
  
 Date 14-08-2021
  
 References-
 https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
 https://leetcode.com/problems/longest-palindromic-subsequence/

 NOTE: Variation of Longest Common Subsequence
*/ 

//------------------------------------------------------------------------------
//Tabulation Approach

class Solution {
public:
    int longestPalindromeSubseq(string s) {
        string reverse_s=s;
        int m=s.size();
        reverse(reverse_s.begin(),reverse_s.end());
        return lcs(m,m,s,reverse_s);
    }
    
    int lcs(int x, int y, string s1, string s2) {
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