/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/robot-return-to-origin/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean judgeCircle(String moves) {
        int left_right=0;
        int up_down=0;
        
        for(char ch:moves.toCharArray()){
            if(ch=='U'){
                up_down++;
            }
            if(ch=='D'){
                up_down--;
            }
            if(ch=='L'){
                left_right--;
            }
            if(ch=='R'){
                left_right++;
            }
        }
        return up_down==0 && left_right==0;        
    }
}