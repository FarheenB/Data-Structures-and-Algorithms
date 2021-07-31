/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/flipping-an-image/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int k=0;k<A.length;k++){
            int i=0;
            int j=A.length-1;
            
            while(i<j){
                int temp=A[k][i];
                A[k][i]=A[k][j];
                A[k][j]=temp;
                A[k][i]=(A[k][i]==1)?0:1;
                A[k][j]=(A[k][j]==1)?0:1;
                i++;
                j--;

            }
            if(i==j){
                A[k][j]=A[k][j]==1?0:1;

            }
        }
        return A;
    }
}
