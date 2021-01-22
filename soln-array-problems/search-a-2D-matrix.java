/*
https://leetcode.com/problems/search-a-2d-matrix/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)
            return false;
        
        int rows=matrix.length;
        int cols=matrix[0].length;
       
        int left=0;
        int right=rows*cols-1;
        
        while(left<=right){
            int mid=left+(right-left)/2;
            int mid_element=matrix[mid/cols][mid%cols];
            if(target<mid_element){
                right=mid-1;
            }   
            else if(target>mid_element){
                left=mid+1;
            }
            else{
                return true;
            }
                
        }
        return false;        
    }
}