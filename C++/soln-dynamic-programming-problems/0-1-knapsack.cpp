/**
 @author Farheen Bano
 
 0/1 Knapsack Problem - Given items of certain weights/values and maximum allowed weight
 how to pick items to pick items from this set to maximize sum of value of items such that
 sum of weights is less than or equal to maximum allowed weight.
 
 Time complexity - O(W*total items)
 
 Reference-
 https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
*/

//------------------------------------------------------------------------------
//Memoization Approach 

class Solution
{
    public:
    int dp[1001][1001];
    //Function to return max value that can be put in knapsack of capacity W.
    int knapSack(int W, int wt[], int val[], int N) { 
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
                            (val[N-1]+KS(W-wt[N-1],wt,val,N-1)),
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
    //Function to return max value that can be put in knapsack of capacity W.
    int knapSack(int W, int wt[], int val[], int N){ 
        int dp[N+1][W+1];
        
        for(int i=0;i<N+1;i++){
            for(int j=0;j<W+1;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
                else if(wt[i-1]<=j){
                    dp[i][j]=max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[N][W];
    }
};