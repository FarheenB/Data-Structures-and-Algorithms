/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/stone-game-iii/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int N=stoneValue.length;
        int i_1=0,i_2=0,i_3=0;
        int i=N-1;

        while(i>=0){            
            int ans=Integer.MIN_VALUE;
            ans=Math.max(ans,stoneValue[i]-i_1);
            if(i+1<stoneValue.length)
                ans=Math.max(ans,stoneValue[i]+stoneValue[i+1]-i_2);
            if(i+2<stoneValue.length)
                ans=Math.max(ans,stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-i_3);
            i_3=i_2;
            i_2=i_1;
            i_1=ans;
            i--;
        }
        
        int alice=i_1;
        if(alice>0)
            return "Alice";
        if(alice==0)
            return "Tie";
        return "Bob";
    }
}
