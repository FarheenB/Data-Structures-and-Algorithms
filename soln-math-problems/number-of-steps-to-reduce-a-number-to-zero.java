/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int numberOfSteps (int num) {
        int steps=0;
        while(num>0){
            if(num%2==0)
                num>>=1;
            else
                num--;
            steps++;
        }
        return steps;
    }
}
