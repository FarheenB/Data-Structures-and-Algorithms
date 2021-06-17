/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/sort-array-by-parity/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] sortArrayByParity(int[] A){
        if(A==null || A.length==0)
            return A;
        
        int index=0;
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){
                int temp=A[index];
                A[index]=A[i];
                A[i]=temp;
                index++;
            }
        }
        return A;
    }
}