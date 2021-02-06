/*
https://www.interviewbit.com/problems/edit-distance/
https://www.geeksforgeeks.org/edit-distance-dp-5/
https://leetcode.com/problems/edit-distance/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=j;
        }
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){           
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1])+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];        
    }
}