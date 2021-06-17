/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/spiral-matrix/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();        
        int top=0, left=0,bottom=matrix.length,right=matrix[0].length;
        
        while(top<bottom && left<right){
            // System.out.println(top+" "+bottom+" "+left+" "+right);

            for(int i=left;i<right;i++){
                list.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<bottom;i++){
                list.add(matrix[i][right-1]);
            }
            right--;
            
            if(top<bottom && left<right){
                for(int i=right-1;i>left-1;i--){
                    list.add(matrix[bottom-1][i]);
                }
                bottom--;
                for(int i=bottom-1;i>top-1;i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
            
            
        }
        return list;
    }
}