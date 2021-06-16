/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/counting-bits
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] countBits(int num) {
        int[] result=new int[num+1];
        
        for(int i=0;i<=num;i++){
            result[i]=Integer.bitCount(i);
        }
        return result;
    }
}
