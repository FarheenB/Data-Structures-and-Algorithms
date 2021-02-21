/*
https://leetcode.com/problems/set-matrix-zeroes
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows=new HashSet<>();
        HashSet<Integer> cols=new HashSet<>();
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        for(int r:rows){
            Arrays.fill(matrix[r],0);
        }
        
        for(int c:cols){
            for(int i=0;i<matrix.length;i++){
                matrix[i][c]=0;
            }
        }
    }
}