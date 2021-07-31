/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/broken-calculator
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int brokenCalc(int X, int Y) {
        if(X==Y)
            return 0;
     
        int steps=0;    
        while(Y>X){
            if(Y%2==0)
                Y/=2;
            else
                Y+=1;
            steps++;
        }
        return steps+(X-Y);
    }
}
