/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/sliding-window-median/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result=new double[nums.length-(k-1)];
        
        int index=0;
        boolean even=false;
        if(k%2==0){
            even=true;
        }
        
        int mid=k/2;

        int i=0;
        int j=0;
        int sum=0;
        ArrayList<Integer> window=new ArrayList<>();
        
        while(j<nums.length){
            window.add(nums[j]);    
            
            if(j-i+1==k){
                Collections.sort(window);
                if(even)
                    result[index++]=(double)(window.get(mid-1)*1.0+window.get(mid)*1.0)/2.0;
                else
                    result[index++]=(double)window.get(mid);
                window.remove(new Integer(nums[i]));
                i++;
            }       
            j++;          
        }
        return result;
    }
}
