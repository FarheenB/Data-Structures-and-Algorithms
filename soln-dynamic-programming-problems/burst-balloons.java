/*
https://leetcode.com/problems/burst-balloons/

NOTE: Variation of Matrix Chain Multiplicaton Problem
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int maxCoins(int[] nums) {

        int n = nums.length + 2;
        int[] new_nums = new int[n];//new array with additional 2 balloons to cover boundaries 

        for(int i = 0; i < nums.length; i++){
            new_nums[i+1] = nums[i];
        }

        new_nums[0] = new_nums[n - 1] = 1; //for out of bound balloons

        int[][] t = new int[n][n];
        for(int[] l:t)
            Arrays.fill(l,-1);
        return solve(new_nums, 0, n - 1,t);
    }
    
    static int solve(int[] nums, int i, int j, int t[][]){
        if(i+1==j)
            return 0;
        
        if(t[i][j]!=-1)
            return t[i][j];
        
        int max=0;
        
        int left,right;
        for(int k=i+1;k<j;k++){
            
            if(t[i][k]!=-1)
                left= t[i][k];
            else
            {
                left=solve(nums,i,k,t);
                t[i][k]=left;
            }
            
            if(t[k][j]!=-1)
                right=t[k][j];
            else
            {
                right=solve(nums,k,j,t);
                t[k][j]=right;
            }
            
            int temp=left+right+(nums[i]*nums[k]*nums[j]);
            max=Math.max(max,temp);
        }
        t[i][j]=max;
        return t[i][j];        
    }
}