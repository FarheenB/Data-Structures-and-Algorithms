/**
 @author Farheen Bano
  
 References-
 https://www.interviewbit.com/problems/3-sum-zero/
 https://leetcode.com/problems/3sum/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Set<List<Integer>> set=new HashSet<>();
        if(arr.length<3)
            return new ArrayList<>(set);

        Arrays.sort(arr);      
        for (int i=0; i<arr.length; i++){
            int j=i+1;
            int k=arr.length-1;
            while(j<k){
                int sum=arr[i]+arr[j]+arr[k];
                if(sum==0){                    
                    List<Integer> triplets=Arrays.asList(arr[i],arr[j],arr[k]);
                    set.add(triplets);
                }                
                if(sum<0)
                    j++;
                else
                    k--;
            }
        }
        return new ArrayList<>(set);    
    }
}
