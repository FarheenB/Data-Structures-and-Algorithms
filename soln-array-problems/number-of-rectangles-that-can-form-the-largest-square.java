/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int squares[]=new int[rectangles.length];
        int i=0;
        int max=0;
        for(int rectangle[]:rectangles){
            squares[i]=Math.min(rectangle[0],rectangle[1]);
            max=Math.max(max,squares[i]);
            i++;
        }
        int count=0;
        for(int sq:squares){
            if(sq==max){
                count++;
            }
        }
        return count;
    }
}