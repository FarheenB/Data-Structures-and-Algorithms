/*
https://leetcode.com/problems/bag-of-tokens/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int points=0;
        int i=0;
        int j=tokens.length-1;
        int max_points=0;
        while(i<=j){
            if(tokens[i]<=P){
                P-=tokens[i];
                points++;
                i++;
                max_points=Math.max(max_points,points);
            }
            else if(points>0){
                P+=tokens[j];
                points--; 
                j--;
            }
            else
                return max_points;
        }
        return max_points;
    }
}