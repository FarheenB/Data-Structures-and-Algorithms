/*
https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

  public int kthSmallest(int[][] matrix, int k) {

    int row = matrix.length;
    int col = matrix[0].length;

    int start = matrix[0][0], end = matrix[row - 1][col - 1];
      
    while (start < end) {
        //hypothetical mid of the matrix elements
        int mid = start + (end - start) / 2;
        // first number is the smallest and the second number is the largest
        int[] smallLargePair = {matrix[0][0], matrix[row - 1][col - 1]};

        int count = this.search(matrix, mid, row, col, smallLargePair);

        if (count == k) 
            return smallLargePair[0];

        if (count < k) 
            start = smallLargePair[1]; // search higher
        else 
            end = smallLargePair[0]; // search lower
    }
    return start;
  }

  public int search(int[][] matrix, int mid, int row, int col, int[] smallLargePair) { 
        int i=row-1;
        int j=0;
        int count=0;
        
        while(i>=0 && j<col){
            if(matrix[i][j] >mid){
                smallLargePair[1] = Math.min(smallLargePair[1], matrix[i][j]);
                i--;
            }
            else{
                smallLargePair[0] = Math.max(smallLargePair[0], matrix[i][j]);
                count=count+i+1;
                j++;
            }
        }
        return count; 
    }
}