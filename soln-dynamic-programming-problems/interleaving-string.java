/*
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/find-if-a-string-is-interleaved-of-two-other-strings-dp-33/
 https://www.interviewbit.com/problems/interleaving-strings/
 https://leetcode.com/problems/interleaving-string
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length()!=s1.length()+s2.length())
            return false;
        
        boolean[][] dp=new boolean[s1.length()+1][s2.length()+1];
        dp[0][0]=true;
        
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i>0 && s1.charAt(i-1)==s3.charAt(i+j-1))
                    dp[i][j]=dp[i][j] || dp[i-1][j];            
                
                if(j>0 && s2.charAt(j-1)==s3.charAt(i+j-1))
                    dp[i][j]=dp[i][j] || dp[i][j-1];                
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
