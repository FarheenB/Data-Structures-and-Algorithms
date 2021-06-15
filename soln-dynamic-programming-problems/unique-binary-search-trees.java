/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/unique-binary-search-trees/

 NOTE: Variation of Catalan Number
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int numTrees(int n) {
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=0;
            for(int j=0;j<i;j++){
                
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}
