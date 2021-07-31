/**
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/
 https://leetcode.com/problems/3sum/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Set<List<Integer>> set=new HashSet<>();
        if(arr.length<2)
            return new ArrayList<>(set);
        Arrays.sort(arr);
        int n=arr.length;
        int sum=0;        
        for (int a=0; a<n-1; a++)
        {
            int j=n-1;
            int i=a+1;
            int x = arr[a];
            while(i<j)
            {
                sum=x+arr[i]+arr[j];
                if(sum==0){
                    
                    List<Integer> triplets=Arrays.asList(x,arr[i],arr[j]);
                    set.add(triplets);
                }
                
                if(sum<0){
                    i++;
                }
                else{
                    j--;
                }
            }
        }
        return new ArrayList<>(set);
    
    }
}

