/*
https://leetcode.com/problems/peak-index-in-a-mountain-array/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int peakIndexInMountainArray(int[] A) {
       if(A.length<3){
            return -1;
        }

        int i=0;
        while(i<A.length && i+1<A.length && A[i]<A[i+1])
            i++;

        if(i==0 || i+1>=A.length)
            return -1;

        return i;
    }
}