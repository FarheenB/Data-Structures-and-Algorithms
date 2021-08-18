/**
 @author Farheen Bano
  
 Reference-
 https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/
*/

//------------------------------------------------------------------------------
//Memoization Approach 

class Solution
{
    public:
    int dp[1001][1001];
    //Function to return max value that can be put in knapsack of capacity W.
    int knapSack(int N, int W, int val[], int wt[]) { 
        memset(dp,-1,sizeof(dp));
        KS(W,wt,val,N);
    }
    
    //Recursive Function
    int KS(int W, int wt[], int val[], int N){
        if(N==0 || W==0)
            return 0;
            
        if(dp[N][W]!=-1){
            return dp[N][W];
        }    
        
        if(wt[N-1]<=W){
            dp[N][W]=max(
                            (val[N-1]+KS(W-wt[N-1],wt,val,N)),
                            KS(W,wt,val,N-1)
                        );
            return dp[N][W];
        }
        dp[N][W]=KS(W,wt,val,N-1);
        return dp[N][W];
    }
};

//------------------------------------------------------------------------------
//Tabulation Approach

class Solution
{
    public:
    int knapSack(int N, int W, int val[], int wt[]) { 
        int dp[N+1][W+1];
        
        for(int i=0;i<N+1;i++){
            for(int j=0;j<W+1;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
                else if(wt[i-1]<=j){
                    dp[i][j]=max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
                }
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[N][W];
    }
};