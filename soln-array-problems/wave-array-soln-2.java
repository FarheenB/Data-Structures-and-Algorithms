/**
 @author Farheen Bano
  
 References-
 https://www.interviewbit.com/problems/wave-array/
 https://www.geeksforgeeks.org/sort-array-wave-form-2/

 Solution 2:
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    public static void convertToWave(int A[], int n){
        for(int i=0;i<A.length;i=i+2){
           if(i>0 && A[i]<A[i-1]){
               A=swap(A,i,i-1);
           } 
           if(i<A.length-1 && A[i]<A[i+1]){
               A=swap(A,i,i+1);
           }
        }
    }
    public static int[] swap(int[] A, int i, int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
        return A;
    }    
}