/**
 @author Farheen Bano
  
 References-
 https://www.interviewbit.com/problems/wave-array/
 https://www.geeksforgeeks.org/sort-array-wave-form-2/

 Solution 1:
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public int[] wave(int[] A) {
        Arrays.sort(A);
        for(int i=0;i<A.length-1;i=i+2){
               A=swap(A,i,i+1);
           } 
        return A;        
    }
    public int[] swap(int[] A, int i, int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
        return A;
    }
}
