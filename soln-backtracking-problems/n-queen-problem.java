/*
https://practice.geeksforgeeks.org/problems/n-queen-problem0315/1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        solveNQueens(n,0,new ArrayList<Integer>(),result);
        return result;
    }
    
    private static void solveNQueens(int n, int row, ArrayList<Integer> colPlacements, ArrayList<ArrayList<Integer>> result){
        if(row==n)
            result.add(new ArrayList<>(colPlacements));
        else{
            for(int col=1;col<=n;col++){
                colPlacements.add(col);
                if(isValid(colPlacements))
                    solveNQueens(n,row+1,colPlacements,result);
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