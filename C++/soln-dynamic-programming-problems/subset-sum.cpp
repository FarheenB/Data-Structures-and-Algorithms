/**
 @author Farheen Bano
  
 Date 14-08-2021

 References-
 https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 https://www.interviewbit.com/problems/subset-sum-problem/

 NOTE: Variation of 0/1 Knapsack
*/

//------------------------------------------------------------------------------
//Memoization Approach 

class Solution{   
public:   
    int dp[101][10001];
    
    bool isSubsetSum(int N, int arr[], int sum){
        memset(dp,-1,sizeof(dp));
        return solve(arr,sum,N)==1?true:false;
    }
    
    //Recursive function
    int solve(int arr[], int sum, int N){
        if(sum==0)
            return 1;
        if(N==0)
            return 0;
        
        if(dp[N][sum]!=-1)
            return dp[N][sum];
        
        if(arr[N-1]<=sum){
            dp[N][sum]=solve(arr,sum-arr[N-1],N-1) || solve(arr,sum,N-1);
            return dp[N][sum];
        }
        dp[N][sum]=solve(arr,sum,N-1);
        return dp[N][sum];
    }
};

//------------------------------------------------------------------------------
//Tabulation Approach

class Solution{   
public:
    bool isSubsetSum(int N, int arr[], int sum){
        bool dp[N+1][sum+1];
        for(int i=0;i<=N;i++){
            for(int j=0;j<=sum;j++){
                if(j==0)
                    dp[i][j]=1;
                
                else if(i==0)
                    dp[i][j]=0;
                
                else if(arr[i-1]<=j)
                    dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
        
            }
        }
        return dp[N][sum]?1:0;
    }
};