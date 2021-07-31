/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/maximize-distance-to-closest-person
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int maxDistToClosest(int[] seats) {
        int n=seats.length;
        int before=-1;
        int after=0;
        int max=0;
        
        for(int i=0;i<n;i++){
            if(seats[i]==1){
                before=i;
            }
            else{
                while(after<n && seats[after]==0 || after<i){
                    after++;
                }
                int left= before==-1? n:i-before;
                int right= after==n? n:after-i;
                
                max=Math.max(max,Math.min(left,right));

            }
        }
        return max;
    }
}