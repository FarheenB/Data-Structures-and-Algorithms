/**
 @author Farheen Bano
  
 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 
 Date 14-08-2021
 
 References-
 https://leetcode.com/problems/climbing-stairs/
 https://www.geeksforgeeks.org/count-ways-reach-nth-stair/

 NOTE: Variation of Fibinacci Series
*/

//Recursive Solution 
//Result in TLE error

class Solution {
    public int climbStairs(int n) {
        return countWays(n+1);
    }
    
    int countWays(int n){
        if (n <= 1)
            return n;
        return countWays(n - 1) + countWays(n - 2);
    }
}


//Dynamic Programming Solution

class Solution {
public:
    int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int* dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
};


//Constant Space Solution

class Solution {
public:
    int climbStairs(int n) {
        if(n==1)
            return 1;
        int a=1;
        int b=2;
        for(int i=3;i<=n;i++){
            int c=a+b;
            a=b;
            b=c;
        }
        return b;
    }
};