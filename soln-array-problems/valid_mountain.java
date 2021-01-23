/*
https://leetcode.com/problems/valid-mountain-array/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean validMountainArray(int[] A) {
        if(A.length<3){
            return false;
        }

        int i=0;
        while(i<A.length && i+1<A.length && A[i]<A[i+1])
            i++;

        if(i==0 || i+1>=A.length)
            return false;

        while(i<A.length && i+1<A.length){
            if(A[i]<=A[i++ +1])
                return false;
        }
        return true;
    }
}