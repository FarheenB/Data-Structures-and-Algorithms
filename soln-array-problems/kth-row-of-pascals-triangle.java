/**
 @author Farheen Bano
  
 Reference-
 https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> list=new ArrayList<>();
        int C=1;
        for(int i = 1; i <= A+1; i++) 
        {  
            list.add(C);
            C = C * (A - i+1) / i;  
        } 
        return list;
    }
}