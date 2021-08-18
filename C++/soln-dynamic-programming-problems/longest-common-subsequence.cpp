/**
 @author Farheen Bano
  
 Date 14-08-2021

 References-
 https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 https://leetcode.com/problems/longest-common-subsequence/
*/

//------------------------------------------------------------------------------
//Memoization Approach
//TLE Problem  

class Solution
{
    public:
    int dp[1001][1001];
    //Function to find the length of longest common subsequence in two strings.
    int lcs(int x, int y, string s1, string s2) {
        memset(dp,-1,sizeof(dp));
        return subsequence(x, y, s1, s2);
    }
    
    //Recursive Function
    int subsequence(int x, int y, string s1, string s2) {
        if(x==0 || y==0)
            return 0;
            
        if(dp[x][y]!=-1)
            return dp[x][y];
            
        if(s1[x-1]==s2[y-1]){
            dp[x][y]= 1+subsequence(x-1,y-1,s1,s2);
            return dp[x][y];
        }
    
        dp[x][y]=max(subsequence(x-1,y,s1,s2),subsequence(x,y-1,s1,s2));
        return dp[x][y];
    }
};

//------------------------------------------------------------------------------
//Tabulation Approach

class Solution
{
    public:
    //Function to find the length of longest common subsequence in two strings.
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