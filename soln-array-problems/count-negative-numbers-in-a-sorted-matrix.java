/*
https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int countNegatives(int[][] grid) {
        int count=0;
        int i=0;
        int j=grid[0].length-1;
        
        while(j>=0 && i<grid.length){
            if(grid[i][j]<0){
                count+=grid.length-i;
                j--;
            }
            else
                i++;
        }
        return count;        
    }
}