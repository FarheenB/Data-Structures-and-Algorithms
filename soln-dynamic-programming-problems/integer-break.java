/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/integer-break/
*/

class Solution {
    public int integerBreak(int n) {
        if(n<2)
            return 0;
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
               dp[i]=Math.max(Math.max(dp[i],(i-j)*j),dp[j]*(i-j));
            }
        }
        return dp[n];
    }
}
