/*
https://www.interviewbit.com/problems/repeat-and-missing-number-array/
https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solve {
    int[] findTwoElement(int nums[], int n) {
        int[] result=new int[2];
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=(i+1)){
                int x=nums[i]-1;
                if(nums[x]==x+1)
                    continue;
                else{
                    int temp=nums[x];
                    nums[x]=nums[i];
                    nums[i]=temp; 
                    i--;
                }
            }
        }    
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=(i+1)){
                result[0]=nums[i];
                result[1]=i+1;
            }
        }
        return result;
    }
}