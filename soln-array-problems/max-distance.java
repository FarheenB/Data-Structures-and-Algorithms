/*
https://www.interviewbit.com/problems/max-distance/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public int maximumGap(final int[] A) {
        int len=A.length;
        
        if(len==1)
            return 0;
        
        int left_min[]=new int[len];
        int right_max[]=new int[len];
        
        left_min[0]=A[0];
        for(int i=1;i<len;i++){
            left_min[i]=Math.min(A[i], left_min[i-1]);
        }
        
        right_max[len-1]=A[len-1];
        for(int i=len-2;i>=0;i--){
            right_max[i]=Math.max(A[i], right_max[i+1]);
        }
        
        int i=0;
        int j=0;
        int max_diff=-1;
        
        while(i<len && j<len){
            if(left_min[i]<=right_max[j]){
                max_diff=Math.max(max_diff,(j-i));
                j++;
            }
            else
                i++;
        }
        return max_diff;
    }
}
