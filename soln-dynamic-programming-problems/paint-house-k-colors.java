/*
https://leetcode.com/problems/paint-house-ii/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int minCostII(int[][] costs) {
        if(costs==null || costs.length==0 || costs[0].length==0){
            return 0;
        }
        
        int k=costs[0].length;
        
        for(int i=1;i<costs.length;i++)
        {
            for(int c=0;c<k;c++){
                int min=Integer.MAX_VALUE;
                for(int j=0;j<k;j++){
                    if(j==c)
                        continue;
                    min=Math.min(min,costs[i-1][j]);
                }
                costs[i][c]+=min;

            }
        }
        
        int min=Integer.MAX_VALUE;
        for(int current_costs:costs[costs.length-1]){
            min=Math.min(min,current_costs);
        }
        return min;
    
    }
}