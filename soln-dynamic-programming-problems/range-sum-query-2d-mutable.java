/*
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/range-sum-query-2d-mutable/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class NumMatrix {
    int[][] dp;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix=matrix;
        if(matrix==null || matrix.length==0)
            return;
        dp=new int[matrix.length+1][matrix[0].length+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){

                dp[i][j]=dp[i-1][j]+dp[i][j-1]+matrix[i-1][j-1];
                dp[i][j]-=dp[i-1][j-1];
        
            }
        }
    }
    
    public void update(int row, int col, int val) {
        this.matrix[row][col]=val;
        updateDP(row, col);
    }
    
    public void updateDP(int r, int c){
        for(int i=r+1;i<dp.length;i++){
            for(int j=c+1;j<dp[0].length;j++){

                dp[i][j]=dp[i-1][j]+dp[i][j-1]+matrix[i-1][j-1];
                dp[i][j]-=dp[i-1][j-1];
        
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1]-dp[row1][col2+1]-dp[row2+1][col1]+dp[row1][col1];
    }
}
/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
