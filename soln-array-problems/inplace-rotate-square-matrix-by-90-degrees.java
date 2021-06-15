/*
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/nplace-rotate-square-matrix-by-90-degrees/
 https://www.interviewbit.com/problems/rotate-matrix/
 https://leetcode.com/problems/rotate-image/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public void rotate(int[][] matrix){
        int N=matrix.length;

        //Transpose matrix        
        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        
        //Swap columns matrix         
        for(int i=0;i<N;i++){
            for(int j=0;j<(N/2);j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][N-1-j];
                matrix[i][N-1-j]=temp;
            }
        }
    }
}
