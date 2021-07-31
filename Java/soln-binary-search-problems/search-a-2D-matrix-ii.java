/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/search-a-2d-matrix-ii/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;
        
        int i=row-1;
        int j=0;
        
        while(i>=0 && j<col){
            int mid_element=matrix[i][j];
            if(target<mid_element){
                i--;
            }
            else if(target>mid_element){
                j++;
            }
            else
                return true;
        }
        return false;        
    }
}
