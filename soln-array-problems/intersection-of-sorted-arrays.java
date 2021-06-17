/**
 @author Farheen Bano
  
 Reference-
 https://www.interviewbit.com/problems/intersection-of-sorted-arrays/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public int[] intersect(final int[] A, final int[] B) {
        List<Integer> intersect=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<A.length && j<B.length){
            if(A[i]==B[j]){
                intersect.add(A[i]);
                i++;
                j++;
            }
            else if(A[i]>B[j]){
                j++;
            }
            else if(A[i]<B[j]){
                i++;
            }
        }
        
        int[] result=new int[intersect.size()];
        int index=0;
        for(int n:intersect)   
            result[index++]=n;
        return result;
    }
}
