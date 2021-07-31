/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/longest-valid-parentheses/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int longestValidParentheses(String s) {
        int[] dp=new int[s.length()];
        int maxLen=0;
        for(int i=1;i<dp.length;i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    if(i>=2)
                        dp[i]=dp[i-2]+2;
                    else
                        dp[i]=2;
                }
                else if(i-dp[i-1]>0 && s.charAt(i-dp[i-1]-1)=='('){
                    if(i-dp[i-1]>=2)
                        dp[i]=dp[i-1]+dp[i-dp[i-1]-2]+2;
                    else
                        dp[i]=dp[i-1]+2;
                }
                maxLen=Math.max(maxLen,dp[i]);
            }
        }
        return maxLen;
    }
}
