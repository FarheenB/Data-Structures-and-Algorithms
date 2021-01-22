/*
https://www.interviewbit.com/problems/pascal-triangle/

Formula: For each element nCr=nCr-1 * (n-r+1/r)
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        
        for(int row = 1; row <= A; row++) 
        { 
            ArrayList<Integer> list=new ArrayList<>();
            int C=1;
            for(int i = 1; i <= row; i++) 
            {  
                list.add(C);
                C = C * (row - i) / i;  
            } 
            result.add(list);
        } 
        return result;
    }
}
