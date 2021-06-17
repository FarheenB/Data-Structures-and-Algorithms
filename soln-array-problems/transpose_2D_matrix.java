/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/transpose-matrix/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[][] transpose(int[][] A) {
        int new_A[][]=new int[A[0].length][A.length];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                new_A[j][i]=A[i][j];                
            }
        }
        return new_A;
    }
}