/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int maxProfit(int[] prices) {
        int[] left=new int[prices.length];
        int[] right=new int[prices.length];
        
        left[0]=0;
        right[prices.length-1]=0;
        
        int leftMin=prices[0];
        for(int i=1;i<prices.length;i++){
            left[i]=Math.max(left[i-1],prices[i]-leftMin);
            leftMin=Math.min(leftMin,prices[i]);
        }

        int rightMax=prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            right[i]=Math.max(right[i+1],rightMax-prices[i]);
            rightMax=Math.max(rightMax,prices[i]);
        }
        
        int profit=0;
        for(int i=0;i<prices.length;i++){
            profit=Math.max(profit,left[i]+right[i]);
        }
        
        return profit;
    }
}
