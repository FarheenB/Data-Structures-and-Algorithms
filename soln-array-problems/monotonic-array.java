/*
https://leetcode.com/problems/monotonic-array/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean isMonotonic(int[] A) {
        boolean increasing=true;
        boolean decreasing=true;
        int i=0;
        while(i<A.length-1){
            if(A[i]>A[i+1])
                increasing=false;
            if(A[i]<A[i+1])
                decreasing=false;
            
            i++;
        }
        return increasing || decreasing;
    }
}