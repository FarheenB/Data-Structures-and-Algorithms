/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/next-closest-time
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public String nextClosestTime(String time) {
        int mins=Integer.parseInt(time.substring(0,2))*60;
        mins+=Integer.parseInt(time.substring(3));
        
        HashSet<Integer> digits=new HashSet<>();
        for(char ch:time.toCharArray()){
            digits.add(ch-'0');
        }
        
        while(true){
            mins=(mins+1)%(24*60);
            int[] nextTime={mins/60/10,mins/60%10,mins%60/10,mins%60%10};
            boolean isValid=true;
            for(int digit:nextTime){
                if(!digits.contains(digit))
                    isValid=false;
            }
            if(isValid){
                return String.format("%02d:%02d",mins/60,mins%60);
            }
        }
    }
}
