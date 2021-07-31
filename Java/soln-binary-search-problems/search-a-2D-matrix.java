/**
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
 https://leetcode.com/problems/search-a-2d-matrix/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    int rows;
    int cols;
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)
            return false;
        
        rows=matrix.length;
        cols=matrix[0].length;        
        return binarySearch(matrix,0,rows*cols-1,target);
    }        
        
    public boolean binarySearch(int[][] matrix, int start, int end, int target){
        while(start<=end){
            int mid=start+(end-start)/2;
            int mid_element=matrix[mid/cols][mid%cols];
            if(target<mid_element){
                end=mid-1;
            }   
            else if(target>mid_element){
                start=mid+1;
            }
            else{
                return true;
            }
                
        }
        return false;        
    }
}
