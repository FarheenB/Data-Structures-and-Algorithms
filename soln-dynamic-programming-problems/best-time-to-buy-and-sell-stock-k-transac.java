/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        //Case-1: n<=1 OR k==0
        if(k==0 || n<=1)
            return 0;
        
        //Case-2: k>=n
        if(2*k>n)
        {
            int res = 0;
            //considering all the elevating curve
            for(int i=1;i<n;++i)
                if(prices[i]>prices[i-1])
                    res+=(prices[i]-prices[i-1]);
            return res;
        }
        
        //Case-3: 1<=k<n
        int[] dp=new int[(2*k)+1];
        dp[0]=-prices[0];
        for(int i=1;i<=2*k;++i)
        {
            if(i%2==0)  //Buy slot
                dp[i]=Integer.MIN_VALUE;
            else    //Sell slot
                dp[i]=0;
        }
        
        for(int i=0;i<n;++i){
            for(int j=0;j<=2*k;++j)
            {
                if(j==0)
                    dp[j]=Math.max(dp[j],-prices[i]);
                else if(j%2==0)         //Buy slot
                    dp[j]=Math.max(dp[j],dp[j-1]-prices[i]);
                else                    //Sell slot
                    dp[j]=Math.max(dp[j],dp[j-1]+prices[i]);
            }            
        }

        return dp[(2*k)-1];
    }
}