/*
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/paint-fence
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int numWays(int n, int k) {
        if(n==0)
            return 0;
        
        //1 fence can be colored k ways
        if(n==1)
            return k;
        
        int same=k*1;
        int diff=k*(k-1);
        int total=same+diff;
        
        for(int i=3;i<=n;i++){
            same=diff*1;
            diff=total*(k-1);
            total=same+diff;
        }
        return total;
    }
}
