/*
https://www.interviewbit.com/problems/nqueens/
https://leetcode.com/problems/n-queens/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        solveNQueensUtil(n,0,new ArrayList<Integer>(),result);
        return result;
    }
    
    private static void solveNQueensUtil(int n, int row, ArrayList<Integer> colPlacements, List<List<String>> result){
        if(row==n){
            ArrayList<String> placements=new ArrayList<>();
            for(int col:colPlacements){
                StringBuilder str=new StringBuilder();
                for(int i=0;i<n;i++){
                    if(col==i)
                        str.append("Q");
                    else
                        str.append(".");
                }
                placements.add(str.toString());
            }            
            result.add(placements);
        }
        else{
            for(int col=0;col<n;col++){
                colPlacements.add(col);
                if(isValid(colPlacements))
                    solveNQueensUtil(n,row+1,colPlacements,result);
                colPlacements.remove(colPlacements.size()-1);
            }
        }
    }
    
    private static boolean isValid(ArrayList<Integer> colPlacements){
        int curRow=colPlacements.size()-1;
        for(int i=0;i<curRow;i++){
            int diff=Math.abs(colPlacements.get(i)-colPlacements.get(curRow));
            if(diff==0 || diff==curRow-i)
                return false;
        }
        return true;
    }
}