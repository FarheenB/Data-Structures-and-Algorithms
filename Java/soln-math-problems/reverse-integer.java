/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/reverse-integer/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int reverse(int x) {
        boolean is_negative=false;
        
        if(x<0){
            is_negative=true;
            x=x*-1;            
        }
        
        long rev=0;
        while(x>0){
            int rem=x%10;
            x=x/10;
            rev=rev*10+rem;
        }
        
        if(rev>Integer.MAX_VALUE)
            return 0;
        
        return is_negative?(int)(-1*rev):(int)rev;
    }
}
